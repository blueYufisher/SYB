/**
 *
 */
package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.LoginRecordMapper;
import cn.edu.gdut.llc.mybatis.mapper.UserMapper;
import cn.edu.gdut.llc.mybatis.mapper.WeixinMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfUserMapper;
import cn.edu.gdut.llc.mybatis.model.*;
import cn.edu.gdut.llc.mybatis.model.self.SelfUser;
import cn.edu.gdut.llc.share.dao.UserDao;
import cn.edu.gdut.llc.share.mesaage.UserParam;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 登录信息持久层
 *
 * @author cpt725
 */
@Repository
public class UserDaoImpl implements UserDao {

    @AutoLogger
    private static Logger logger;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SelfUserMapper selfUserMapper;
    @Autowired
    private LoginRecordMapper loginRecordMapper;
    @Autowired
    private WeixinMapper weixinMapper;

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
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(username);
        List<User> list = userMapper.selectByExample(userExample);
        if (list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    @Override
    public User updateById(User user) {
        /**
         * describe: 根据id更新登录信息
         * class_name: updateById
         * param: [user]
         * return: cn.edu.gdut.llc.mybatis.model.User
         * creat_user: ZHAN
         * creat_date: 2018/1/13/0013
         * creat_time: 14:41
         **/
        userMapper.updateByPrimaryKeySelective(user);
        return user;
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
        User user = null;
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(account);

        UserExample.Criteria criteria1 = userExample.createCriteria();
        criteria1.andPhoneEqualTo(account);

        UserExample.Criteria criteria2 = userExample.createCriteria();
        criteria2.andMailEqualTo(account);

        userExample.or(criteria1);
        userExample.or(criteria2);
        List<User> list = userMapper.selectByExample(userExample);
        if (!list.isEmpty())
            user = list.get(0);
        return user;
    }

    @Override
    public LoginRecord insertLoginRecord(LoginRecord loginRecord) {
        /**
         * describe: 添加登录记录
         * class_name: insertLoginRecord
         * param: [loginRecord]
         * return: cn.edu.gdut.llc.mybatis.model.LoginRecord
         * creat_user: ZHAN
         * creat_date: 2018/1/13/0013
         * creat_time: 14:47
         **/
        loginRecordMapper.insert(loginRecord);
        return loginRecord;
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
        LoginRecordExample userExample = new LoginRecordExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        return loginRecordMapper.selectByExample(userExample);
    }

    @Override
    public Weixin getWeixinByWeixinOpenid(String openid) {
        /**
         * describe: 根据微信openid获取微信资料
         * class_name: getWeixinByWeixinOpenid
         * param: [openid]
         * return: cn.edu.gdut.llc.mybatis.model.Weixin
         * creat_user: ZHAN
         * creat_date: 2018/1/13/0013
         * creat_time: 14:52
         **/
        return weixinMapper.selectByPrimaryKey(openid);
    }

    @Override
    public Integer insertUser(User user) {
        /**
         * describe: 插入新登录信息
         * class_name: insertUser
         * param: [user]
         * return: java.lang.Integer
         * creat_user: ZHAN
         * creat_date: 2018/2/12/0012
         * creat_time: 18:07
         **/
        selfUserMapper.insertUserReturnID(user);
        return user.getId();
    }

    @Override
    public Weixin insertWeixin(Weixin weixin) {
        /**
         * describe: 插入微信用户信息
         * class_name: insertWeixin
         * param: [weixin]
         * return: cn.edu.gdut.llc.mybatis.model.Weixin
         * creat_user: ZHAN
         * creat_date: 2018/1/13/0013
         * creat_time: 14:53
         **/
        weixinMapper.insertSelective(weixin);
        return weixin;
    }

    @Override
    public Weixin updateWeixin(Weixin weixin) {
        /**
         * describe: 更新微信用户信息
         * class_name: updateWeixin
         * param: [weixin]
         * return: cn.edu.gdut.llc.mybatis.model.Weixin
         * creat_user: ZHAN
         * creat_date: 2018/1/13/0013
         * creat_time: 14:53
         **/
        weixinMapper.updateByPrimaryKeySelective(weixin);
        return weixin;
    }

    @Override
    public List<User> getUsersByKeywords(String keywords) {
        return selfUserMapper.getUsersByKeywords(keywords);
    }

    @Override
    public int deleteRoleByUserId(Integer userId) {
        return selfUserMapper.deleteRoleByUserId(userId);
    }

    @Override
    public int addRolesForUser(UserParam<User> msg) {
        return selfUserMapper.addRolesForUser(msg);
    }

    @Override
    public SelfUser getUserById(Integer userId) {
        return selfUserMapper.getUserById(userId);
    }

    @Override
    public int deleteUser(Integer userId) {
        return selfUserMapper.deleteUser(userId);
    }

    @Override
    public List<User> getAllUser(Integer userId) {
        return selfUserMapper.getAllUser(userId);
    }

}
