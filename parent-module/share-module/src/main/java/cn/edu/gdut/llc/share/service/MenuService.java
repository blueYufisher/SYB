package cn.edu.gdut.llc.share.service;

import cn.edu.gdut.llc.mybatis.model.Menu;

import java.security.Principal;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-07 21:24
 **/
public interface MenuService {

    /**
     * describe: 获取全部的菜单
     * class_name: getAllMenu
     * param: [request]
     * return: cn.edu.gdut.llc.share.response.ResponseMessage
     * creat_user: ZHAN
     * creat_date: 2018/2/12/0012
     * creat_time: 23:47
     **/
    List<Menu> getAllMenu();

    /**
     * describe: 根据登录用户获取菜单
     * class_name: getMenusByUserId
     * param: [request, principal]
     * return: cn.edu.gdut.llc.share.response.ResponseMessage
     * creat_user: ZHAN
     * creat_date: 2018/2/12/0012
     * creat_time: 23:47
     **/
    List<Menu> getMenusByUserId(Principal principal);

    /**
     * describe: 查看某人菜单权限
     * class_name: menuTree
     * param: [rid]
     * return: cn.edu.gdut.llc.share.response.ResponseMessage
     * creat_user: ZHAN
     * creat_date: 2018/2/12/0012
     * creat_time: 23:45
     **/
    List<Menu> menuTree();

    /**
     * describe: 根据权限id获取菜单
     * class_name: getMenusByRid
     * param: [request, rid]
     * return: cn.edu.gdut.llc.share.response.ResponseMessage
     * creat_user: ZHAN
     * creat_date: 2018/2/12/0012
     * creat_time: 23:47
     **/
    List<Integer> getMenusByRid(Integer rid);
}
