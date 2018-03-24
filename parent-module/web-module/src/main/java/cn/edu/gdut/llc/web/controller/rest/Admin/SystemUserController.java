package cn.edu.gdut.llc.web.controller.rest.Admin;

import cn.edu.gdut.llc.message.CSparam;
import cn.edu.gdut.llc.message.SCresponse;
import cn.edu.gdut.llc.mybatis.model.User;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.mesaage.UserParam;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.UserService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import cn.edu.gdut.llc.share.util.LoggerUtils;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-02-13 12:30
 **/
@RestController
@RequestMapping("/system/hr")
public class SystemUserController {
    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @RequestMapping("/id/{userId}")
    public ResponseMessage getUserById(HttpServletRequest request, @PathVariable Integer userId) {
        logger.debug("getUserById userId：" + userId);
        ResponseMessage message = new ResponseMessage();
        try {
            Object data = userService.getUserById(userId);
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

    @RequestMapping("/{userId}")
    public ResponseMessage deleteUser(HttpServletRequest request, @PathVariable Integer userId){
        logger.debug("deleteUser: userId: " + userId);
        ResponseMessage message = new ResponseMessage();
        try {
            if (userService.deleteUser(userId) == 1) {
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

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseMessage updateUser(HttpServletRequest request,@RequestBody(required = false) User user){
        logger.debug("updateUser: user: " + user);
        ResponseMessage message = new ResponseMessage();
        try {
            if (userService.updateUser(user)) {
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

    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public ResponseMessage updateUserRoles(@RequestBody(required = false) UserParam<User> msg) {
        logger.debug("updateUserRoles: msg: " + msg);
        ResponseMessage message = new ResponseMessage();
        try {
            if (userService.updateUserRoles(msg) == msg.getRids().length) {
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

    @RequestMapping("/getUsersByKeywords/{keywords}")
    public ResponseMessage getUsersByKeywords(HttpServletRequest request,
                                              @PathVariable String keywords) {
        /**
         * describe: 根据关键词搜索用户
         * class_name: getUsersByKeywords
         * param: [request, keywords]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/2/13/0013
         * creat_time: 14:09
         **/
        logger.debug("getUsersByKeywords msg:" + keywords);
        // 创建返回值对象
        ResponseMessage message = new ResponseMessage();
        try {
            List<User> res = userService.getUsersByKeywords(keywords);
            JSONObject obj = new JSONObject();
            obj.put("res:", res);
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            message.setData(res);
            message.setStatus(true);

        } catch (Exception e) {
            message.setStatus(false);
            message.setMessage(e.toString());
            e.printStackTrace();
        }

        return message;

    }

}
