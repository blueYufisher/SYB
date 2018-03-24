package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.Role;
import cn.edu.gdut.llc.mybatis.model.User;
import cn.edu.gdut.llc.mybatis.model.self.SelfUser;
import cn.edu.gdut.llc.share.mesaage.UserParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelfUserMapper {

    Integer insertUserReturnID(User user);

    User loadUserByUsername(String username);

    List<Role> getRolesByUserId(Integer id);

    int userReg(User user);

    List<User> getUsersByKeywords(@Param("keywords") String keywords);

//    int updateUser(User user);

    int deleteRoleByUserId(Integer userId);

    int addRolesForUser(UserParam<User> msg);

    SelfUser getUserById(Integer userId);

    int deleteUser(Integer userId);

    List<User> getAllUser(Integer userId);

}