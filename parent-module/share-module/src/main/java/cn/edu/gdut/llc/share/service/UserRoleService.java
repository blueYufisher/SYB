package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.mybatis.model.UserRole;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-12 17:41
 **/
public interface UserRoleService {

    /**
     * describe: 插入新登录权限信息
     * class_name: insertUserRole
     * param: [userRole]
     * return: cn.edu.gdut.llc.mybatis.model.UserRole
     * creat_user: ZHAN
     * creat_date: 2018/2/12/0012
     * creat_time: 17:40
     **/
    Boolean insertUserRole(UserRole userRole);
}
