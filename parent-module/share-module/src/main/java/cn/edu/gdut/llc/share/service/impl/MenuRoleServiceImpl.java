package cn.edu.gdut.llc.share.service.impl;

import cn.edu.gdut.llc.mybatis.model.MenuRole;
import cn.edu.gdut.llc.share.dao.MenuRoleDao;
import cn.edu.gdut.llc.share.mesaage.MenuParam;
import cn.edu.gdut.llc.share.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-12 23:17
 **/
@Service
public class MenuRoleServiceImpl implements MenuRoleService{

    @Autowired
    @Qualifier("menuRoleDaoImpl")
    private MenuRoleDao menuRoleDao;

    @Override
    public int updateMenuRole(MenuParam<MenuRole> msg) {
        /**
         * describe: 更新权限
         * class_name: updateMenuRole
         * param: [msg]
         * return: int
         * creat_user: ZHAN
         * creat_date: 2018/2/12/0012
         * creat_time: 23:48
         **/
        Integer[] mids = msg.getMids();
        menuRoleDao.deleteMenuByRid(msg.getParamObj());
        if (mids.length == 0) {
            return 0;
        }
        return menuRoleDao.addMenu(msg);
    }
}
