package cn.edu.gdut.llc.web.controller.rest.Admin;

import cn.edu.gdut.llc.mybatis.model.Menu;
import cn.edu.gdut.llc.mybatis.model.MenuRole;
import cn.edu.gdut.llc.mybatis.model.Role;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.mesaage.MenuParam;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.MenuRoleService;
import cn.edu.gdut.llc.share.service.MenuService;
import cn.edu.gdut.llc.share.service.RoleService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import cn.edu.gdut.llc.share.util.LoggerUtils;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-12 22:12
 **/
@RestController
@RequestMapping("/system/basic")
public class SystemBasicController {
    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("roleServiceImpl")
    private RoleService roleService;
    @Autowired
    @Qualifier("menuRoleServiceImpl")
    private MenuRoleService menuRoleService;
    @Autowired
    @Qualifier("menuServiceImpl")
    private MenuService menuService;

    @RequestMapping(value = "/role/{rid}")
    public ResponseMessage deleteRole(@PathVariable Integer rid) {
        /**
         * describe: 删除权限
         * class_name: deleteRole
         * param: [rid]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/2/12/0012
         * creat_time: 23:43
         **/
        logger.debug("deleteRole: rid: " + rid);
        ResponseMessage message = new ResponseMessage();
        try {
            if (roleService.deleteRoleById(rid) == 1) {
                message.setData(true);
                message.setStatus(true);
                message.setMessage("success 删除成功!");
            } else {
                message.setStatus(false);
                message.setMessage("error 删除失败!");
            }
        }catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
        }
        return message;
    }

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public ResponseMessage addNewRole(@RequestBody(required = false) Role paramObj) {
        /**
         * describe: 添加新的权限
         * class_name: addNewRole
         * param: [paramObj]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/2/12/0012
         * creat_time: 23:43
         **/
        logger.debug("addRole: paramObj: " + paramObj);
        ResponseMessage message = new ResponseMessage();
        try {
            if (roleService.addNewRole(paramObj) == 1) {
                JSONObject obj = new JSONObject();
                message.setData(true);
                message.setStatus(true);
                message.setMessage("success 添加成功!");
            } else {
                message.setStatus(false);
                message.setMessage("error 添加失败!");
            }
        }catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
        }
        return message;
    }

    @RequestMapping("/roles")
    public List<Role> allRoles() {
        /**
         * describe: 获取全部权限
         * class_name: allRoles
         * param: []
         * return: java.util.List<cn.edu.gdut.llc.mybatis.model.Role>
         * creat_user: ZHAN
         * creat_date: 2018/2/12/0012
         * creat_time: 23:44
         **/
        return roleService.roles();
    }

    @RequestMapping(value = "/updateMenuRole", method = RequestMethod.POST)
    public ResponseMessage updateMenuRole(@RequestBody(required = false) MenuParam<MenuRole> msg) {
        /**
         * describe: 更新权限
         * class_name: updateMenuRole
         * param: [msg]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/2/12/0012
         * creat_time: 23:45
         **/
        logger.debug("updateMenuRole: msg: " + msg);
        ResponseMessage message = new ResponseMessage();
        try {
            if (menuRoleService.updateMenuRole(msg) == msg.getMids().length) {
                JSONObject obj = new JSONObject();
                message.setData(true);
                message.setStatus(true);
                message.setMessage("success 更新成功!");
            } else {
                message.setStatus(false);
                message.setMessage("error 更新失败!");
            }
        }catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
        }
        return message;
    }

    @RequestMapping(value = "/menuTree/{rid}", method = RequestMethod.GET)
    public ResponseMessage menuTree(@PathVariable Integer rid) {
        /**
         * describe: 查看某人菜单权限
         * class_name: menuTree
         * param: [rid]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/2/12/0012
         * creat_time: 23:45
         **/
        logger.debug("menuTree");
        ResponseMessage message = new ResponseMessage();
        try {
            Map<String, Object> map = new HashMap<>();
            List<Menu> menus = menuService.menuTree();
            map.put("menus", menus);
            List<Integer> selMids = menuService.getMenusByRid(rid);
            map.put("mids", selMids);
            message.setData(map);
            message.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
        }
        return message;
    }
}
