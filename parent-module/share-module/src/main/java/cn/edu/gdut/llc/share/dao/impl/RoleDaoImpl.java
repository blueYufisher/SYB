package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.RoleMapper;
import cn.edu.gdut.llc.mybatis.mapper.self.SelfRoleMapper;
import cn.edu.gdut.llc.mybatis.model.Role;
import cn.edu.gdut.llc.mybatis.model.RoleExample;
import cn.edu.gdut.llc.share.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-08 10:19
 **/
@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private SelfRoleMapper selfRoleMapper;

    @Override
    public Role getRoleNameByRoleId(Integer rId) {
        return roleMapper.selectByPrimaryKey(rId);
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andNameEqualTo(roleName);
        List<Role> list = roleMapper.selectByExample(roleExample);
        if (list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    @Override
    public List<Role> getRolesByUserId(Integer userId) {
        return selfRoleMapper.getRolesByUserId(userId);
    }

    @Override
    public List<Role> roles() {
        return selfRoleMapper.roles();
    }

    @Override
    public int addNewRole(Role role) {
        String roleName = role.getName();
        String roleZh = role.getNamezh();
        if (!roleName.startsWith("ROLE_")) {
            roleName = "ROLE_" + roleName;
            role.setName(roleName);
        }
        return selfRoleMapper.addNewRole(role);
    }

    @Override
    public int deleteRoleById(Integer rid) {
        return selfRoleMapper.deleteRoleById(rid);
    }
}
