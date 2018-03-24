package cn.edu.gdut.llc.mybatis.mapper.self;

import cn.edu.gdut.llc.mybatis.model.Menu;

import java.util.List;

public interface SelfMenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByUserId(Integer userId);

    List<Menu> menuTree();

    List<Integer> getMenusByRid(Integer rid);
}