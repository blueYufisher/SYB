package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.mybatis.model.Login;
import cn.edu.gdut.llc.mybatis.model.Menu;
import cn.edu.gdut.llc.mybatis.model.User;
import cn.edu.gdut.llc.share.dao.MenuDao;
import cn.edu.gdut.llc.share.service.LoginService;
import cn.edu.gdut.llc.share.service.MenuService;
import cn.edu.gdut.llc.share.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-07 21:25
 **/
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    @Qualifier("menuDaoImpl")
    private MenuDao menuDao;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Override
    public List<Menu> getAllMenu() {
        return menuDao.getAllMenu();
    }

    @Override
    public List<Menu> getMenusByUserId(Principal principal) {
        User currentLogin = userService.getCurrentUser(principal);
        System.out.println("********" + currentLogin.getId());
        Integer userId = currentLogin.getId();
        return menuDao.getMenusByUserId(userId);
    }

    @Override
    public List<Menu> menuTree() {
        return menuDao.menuTree();
    }

    @Override
    public List<Integer> getMenusByRid(Integer rid) {
        return menuDao.getMenusByRid(rid);
    }
}
