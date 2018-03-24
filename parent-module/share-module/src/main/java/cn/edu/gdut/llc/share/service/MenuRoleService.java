package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.mybatis.model.MenuRole;
import cn.edu.gdut.llc.share.mesaage.MenuParam;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-12 23:16
 **/
public interface MenuRoleService {

    /**
     * describe: 更新权限
     * class_name: updateMenuRole
     * param: [msg]
     * return: int
     * creat_user: ZHAN
     * creat_date: 2018/2/12/0012
     * creat_time: 23:48
     **/
    int updateMenuRole(MenuParam<MenuRole> msg);
}
