package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.UserRole;

public interface SelfUserRoleMapper {

    /**
     * describe: 插入新登录权限信息
     * class_name: insertUserRole
     * param: [userRole]
     * return: java.lang.Integer
     * creat_user: ZHAN
     * creat_date: 2018/2/12/0012
     * creat_time: 18:01
     **/
    Integer insertUserRoleReturnID(UserRole userRole);

}