package cn.edu.gdut.llc.share.dao;

import cn.edu.gdut.llc.mybatis.model.Menu;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-07 20:49
 **/
public interface MenuDao {

    List<Menu> getAllMenu();

    List<Menu> getMenusByUserId(Integer userId);

    List<Menu> menuTree();

    List<Integer> getMenusByRid(Integer rid);
}
