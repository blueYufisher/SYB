package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.mybatis.model.UserRole;
import cn.edu.gdut.llc.share.dao.UserRoleDao;
import cn.edu.gdut.llc.share.service.UserRoleService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-12 17:43
 **/
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    @Qualifier("userRoleDaoImpl")
    private UserRoleDao userRoleDao;

    @AutoLogger
    private static Logger logger;

    @Override
    public Boolean insertUserRole(UserRole userRole) {
        logger.debug("insertUser");
        boolean flag = false;
        try {
            userRoleDao.insertUserRole(userRole);
            flag = true;
            return flag;
        } catch (Exception e) {
            logger.error(e.toString());
            return flag;
        }
    }
}
