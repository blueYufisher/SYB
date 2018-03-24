package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.self.SelfMenuRoleMapper;
import cn.edu.gdut.llc.mybatis.model.MenuRole;
import cn.edu.gdut.llc.share.dao.MenuRoleDao;
import cn.edu.gdut.llc.share.mesaage.MenuParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-12 23:14
 **/
@Repository
public class MenuRoleDaoImpl implements MenuRoleDao{

    @Autowired
    private SelfMenuRoleMapper selfMenuRoleMapper;

    @Override
    public int deleteMenuByRid(MenuRole menuRole) {
            /**
             * describe: 根据权限id删除菜单权限
             * class_name: deleteMenuByRid
             * param: [menuRole]
             * return: int
             * creat_user: ZHAN
             * creat_date: 2018/2/12/0012
             * creat_time: 23:46
             **/
        return selfMenuRoleMapper.deleteMenuByRid(menuRole);
    }

    @Override
    public int addMenu(MenuParam<MenuRole> msg) {
        /**
         * describe: 根据权限id添加菜单权限
         * class_name: addMenu
         * param: [msg]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/2/12/0012
         * creat_time: 23:46
         **/
        return selfMenuRoleMapper.addMenu(msg);
    }
}
