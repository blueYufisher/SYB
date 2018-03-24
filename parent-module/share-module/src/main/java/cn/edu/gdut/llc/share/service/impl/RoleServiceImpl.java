package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.mybatis.model.Role;
import cn.edu.gdut.llc.share.dao.RoleDao;
import cn.edu.gdut.llc.share.service.RoleService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-08 10:43
 **/
@Service
public class RoleServiceImpl implements RoleService{
    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("roleDaoImpl")
    private RoleDao roleDao;

    @Override
    public Role getRoleNameByRoleId(Integer rId) {
        return roleDao.getRoleNameByRoleId(rId);
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        logger.debug("getRoleByRoleName:" + roleName);
        Role role = null;
        try {
            role = roleDao.getRoleByRoleName(roleName);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return role;
    }

    @Override
    public List<Role> getRolesByUserId(Integer userId) {
        return roleDao.getRolesByUserId(userId);
    }

    @Override
    public List<Role> roles() {
        return roleDao.roles();
    }

    @Override
    public int addNewRole(Role role) {
        logger.debug("addNewRole");
        if (isAleardyExist(role.getName())) {
            throw new RuntimeException("该权限已存在");
        } else {
            return roleDao.addNewRole(role);
        }
    }

    @Override
    public int deleteRoleById(Integer rid) {
        return roleDao.deleteRoleById(rid);
    }

    private boolean isAleardyExist(String roleName) {
        Role role = roleDao.getRoleByRoleName(roleName);
        Role role1 = roleDao.getRoleByRoleName("ROLE_" + roleName);
        if (role == null && role1 == null) {
            return false;
        }
        return true;
    }
}
