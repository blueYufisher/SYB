package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.mybatis.model.Role;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-08 10:42
 **/
public interface RoleService {
    Role getRoleNameByRoleId(Integer rId);

    Role getRoleByRoleName(String roleName);

    List<Role> getRolesByUserId(Integer userId);

    List<Role> roles();

    int addNewRole(Role role);

    int deleteRoleById(Integer rid);

}
