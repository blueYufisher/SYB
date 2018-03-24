package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.UserRoleMapper;
import cn.edu.gdut.llc.mybatis.model.UserRole;
import cn.edu.gdut.llc.share.dao.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-12 17:38
 **/
@Repository
public class UserRoleDaoImpl implements UserRoleDao {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserRole insertUserRole(UserRole userRole) {
        /**
         * describe: 插入新登录权限信息
         * class_name: insertUserRole
         * param: [userRole]
         * return: cn.edu.gdut.llc.mybatis.model.UserRole
         * creat_user: ZHAN
         * creat_date: 2018/2/12/0012
         * creat_time: 17:40
         **/
        userRoleMapper.insertSelective(userRole);
        return userRole;
    }
}
