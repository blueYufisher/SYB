package cn.edu.gdut.llc.web.controller.rest.Admin;

import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.MenuService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import cn.edu.gdut.llc.share.util.LoggerUtils;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-07 21:28
 **/
@RestController
public class MenuRestController {

    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("menuServiceImpl")
    private MenuService menuService;

    @RequestMapping("/getAllMenu")
    public ResponseMessage getAllMenu(HttpServletRequest request) {
        /**
         * describe: 获取全部的菜单
         * class_name: getAllMenu
         * param: [request]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/2/12/0012
         * creat_time: 23:47
         **/
        logger.debug("getAllMenu");
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = menuService.getAllMenu();
            JSONObject obj = new JSONObject();
            obj.put("data:", data);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(data);
            message.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
        }
        return message;
    }

    @RequestMapping("/sysmenu")
    public ResponseMessage getMenusByUserId(HttpServletRequest request, Principal principal) {
        /**
         * describe: 根据登录用户获取菜单
         * class_name: getMenusByUserId
         * param: [request, principal]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/2/12/0012
         * creat_time: 23:47
         **/
        logger.debug("getMenusByUserId: Principal: " + principal);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = menuService.getMenusByUserId(principal);
            JSONObject obj = new JSONObject();
            obj.put("data:", data);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(data);
            message.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
        }
        return message;
    }

    @RequestMapping("/getMenusByRid")
    public ResponseMessage getMenusByRid(HttpServletRequest request, @RequestParam("rid") Integer rid) {
        /**
         * describe: 根据权限id获取菜单
         * class_name: getMenusByRid
         * param: [request, rid]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/2/12/0012
         * creat_time: 23:47
         **/
        logger.debug("getMenusByRid: rid" + rid);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = menuService.getMenusByRid(rid);
            JSONObject obj = new JSONObject();
            obj.put("data:", data);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(data);
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
