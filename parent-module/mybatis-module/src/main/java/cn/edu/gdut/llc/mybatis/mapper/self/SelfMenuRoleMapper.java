package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.MenuRole;
import cn.edu.gdut.llc.share.mesaage.MenuParam;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-12 23:03
 **/
public interface SelfMenuRoleMapper {

    /**
     * describe: 根据权限id删除菜单权限
     * class_name: deleteMenuByRid
     * param: [menuRole]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2018/2/12/0012
     * creat_time: 23:46
     **/
    int deleteMenuByRid(MenuRole menuRole);

    /**
     * describe: 根据权限id添加菜单权限
     * class_name: addMenu
     * param: [msg]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2018/2/12/0012
     * creat_time: 23:46
     **/
    int addMenu(MenuParam<MenuRole> msg);

}
