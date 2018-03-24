package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.mybatis.model.LoginRecord;
import cn.edu.gdut.llc.mybatis.model.User;
import cn.edu.gdut.llc.mybatis.model.UserRole;
import cn.edu.gdut.llc.mybatis.model.self.SelfUser;
import cn.edu.gdut.llc.share.dao.UserDao;
import cn.edu.gdut.llc.share.mesaage.UserParam;
import cn.edu.gdut.llc.share.service.UserRoleService;
import cn.edu.gdut.llc.share.service.UserService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-13 14:55
 **/
@Service
public class UserServiceImpl implements UserService {

    @AutoLogger
    private static Logger logger;
    @Autowired
    private Environment env;
    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;
    @Autowired
    @Qualifier("userRoleServiceImpl")
    private UserRoleService userRoleService;

    @Override
    public User getUserByUsername(String username) {
        /**
         * describe: 根据用户名获取登录信息
         * class_name: getUserByUsername
         * param: [username]
         * return: cn.edu.gdut.llc.mybatis.model.User
         * creat_user: ZHAN
         * creat_date: 2018/1/13/0013
         * creat_time: 14:41
         **/
        logger.debug("getUserByUsername:" + username);
        User user = null;
        try {
            user = userDao.getUserByUsername(username);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        /**
         * describe: 根据id更新登录信息
         * class_name: updateById
         * param: [user]
         * return: cn.edu.gdut.llc.mybatis.model.User
         * creat_user: ZHAN
         * creat_date: 2018/1/13/0013
         * creat_time: 14:41
         **/
        logger.debug("updateUser");
        boolean flag = false;
        try {
            userDao.updateById(user);
            flag = true;
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return flag;
    }

    @Override
    public User getUserByAccount(String account) {
        /**
         * describe: 根据登录账号（手机、邮箱或登录名）获取登录信息
         * class_name: getUserByAccount
         * param: [account]
         * return: cn.edu.gdut.llc.mybatis.model.User
         * creat_user: ZHAN
         * creat_date: 2018/1/13/0013
         * creat_time: 14:43
         **/
        logger.debug("getUserByAccount:" + account);
        User user = null;
        try {
            user = userDao.getUserByAccount(account);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return user;
    }

    @Override
    public boolean insertLoginRecord(LoginRecord loginRecord) {
        /**
         * describe: 添加登录记录
         * class_name: insertLoginRecord
         * param: [loginRecord]
         * return: cn.edu.gdut.llc.mybatis.model.LoginRecord
         * creat_user: ZHAN
         * creat_date: 2018/1/13/0013
         * creat_time: 14:47
         **/
        logger.debug("insertLoginRecord");
        boolean flag = false;
        try {
            userDao.insertLoginRecord(loginRecord);
            flag = true;
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return flag;
    }

    @Override
    public List<LoginRecord> getLoginRecordByUsername(String username) {
        /**
         * describe: 根据用户名获取登录记录
         * class_name: getLoginRecordByUsername
         * param: [username]
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.LoginRecord>
         * creat_user: ZHAN
         * creat_date: 2018/1/13/0013
         * creat_time: 14:48
         **/
        logger.debug("getLoginRecordByUsername");
        List<LoginRecord> list = new ArrayList<>();
        try {
            list = userDao.getLoginRecordByUsername(username);

        } catch (Exception e) {
            logger.error(e.toString());
        }
        return list;
    }

    @Override
    public User getUserByWeixin(String code) throws Exception {
        return null;
    }

    @Override
    public User getCurrentUser(Principal principal) {
        //获取当前登录的用户名
        if (principal == null) {
            System.out.println("********");
            throw new RuntimeException("您还没有登录！");
        }

        String username = principal.getName();
        if (username == null) {
            System.out.println("##########");
            throw new RuntimeException("您还没有登录！");
        }

        return getUserByAccount(username);
    }

    @Override
    public boolean insertUser(User user) {
        logger.debug("insertUser");
        boolean flag = false;
        try {
            if (isAleardyExist(user.getUserName())){
                throw new RuntimeException("该用户名已被注册");
            } else {
                Date date = new Date();
                //更新登录信息
                user.setLogTime(date);
                user.setLogCount(0);
                user.setState(0);
                Integer userId = userDao.insertUser(user);
                UserRole userRole = new UserRole();
                userRole.setRoleId(5);
                userRole.setUserId(userId);
                userRoleService.insertUserRole(userRole);
                flag = true;
                return flag;
            }
        } catch (Exception e) {
            logger.error(e.toString());
            return flag;
        }
    }

    @Override
    public List<User> getUsersByKeywords(String keywords) {
        return userDao.getUsersByKeywords(keywords);
    }

    @Override
    public int updateUserRoles(UserParam<User> msg) {
        Integer userId = msg.getParamObj().getId();
        Integer[] rids = msg.getRids();
        int i = userDao.deleteRoleByUserId(userId);
        return userDao.addRolesForUser(msg);
    }

    @Override
    public SelfUser getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public int deleteUser(Integer userId) {
        return userDao.deleteUser(userId);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser(null);
    }

    @Override
    public List<User> getAllUserExceptAdmin(Principal principal) {
        User currentLogin = getCurrentUser(principal);
        System.out.println("********" + currentLogin.getId());
        Integer userId = currentLogin.getId();
        return userDao.getAllUser(userId);
    }

    private boolean isAleardyExist(String userName) {
        User user = userDao.getUserByUsername(userName);
        if (user == null) {
            return false;
        }
        return true;
    }
}
