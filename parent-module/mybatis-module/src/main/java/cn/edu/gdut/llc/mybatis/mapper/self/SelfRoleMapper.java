package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelfRoleMapper {

    List<Role> getRolesByUserId(Integer userId);

    List<Role> roles();

    int addNewRole(Role role);

    int deleteRoleById(Integer rid);
}