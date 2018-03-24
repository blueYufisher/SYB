package cn.edu.gdut.llc.share.dao.impl;

import cn.edu.gdut.llc.mybatis.mapper.self.SelfMenuMapper;
import cn.edu.gdut.llc.mybatis.model.Menu;
import cn.edu.gdut.llc.share.dao.InfosDao;
import cn.edu.gdut.llc.share.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-07 20:50
 **/
@Repository
public class MenuDaoImpl implements MenuDao{

    @Autowired
    private SelfMenuMapper selfMenuMapper;

    @Override
    public List<Menu> getAllMenu() {
        return selfMenuMapper.getAllMenu();
    }

    @Override
    public List<Menu> getMenusByUserId(Integer userId) {
        return selfMenuMapper.getMenusByUserId(userId);
    }

    @Override
    public List<Menu> menuTree() {
        return selfMenuMapper.menuTree();
    }

    @Override
    public List<Integer> getMenusByRid(Integer rid) {
        return selfMenuMapper.getMenusByRid(rid);
    }
}
