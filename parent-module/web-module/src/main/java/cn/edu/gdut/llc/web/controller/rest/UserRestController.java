package cn.edu.gdut.llc.web.controller.rest;

import cn.edu.gdut.llc.mybatis.model.User;
import cn.edu.gdut.llc.security.service.CustomUserDetailsService;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.UserService;
import cn.edu.gdut.llc.share.util.AutoLogger;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-13 21:31
 **/
@RestController
public class UserRestController {

    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @RequestMapping("/getUserByUsername")
    public ResponseMessage getUserByUsername(@RequestParam("userName") String userName) {
        /**
         * describe: 根据id查Info
         * class_name: selectGuideById
         * param: [id]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2017/12/9/0009
         * creat_time: 15:54
         **/
        logger.debug("getUserByUsername userName：" + userName);
        ResponseMessage message = new ResponseMessage();
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Iterator<?> iterator = userDetails.getAuthorities().iterator();
            String authorities = "";
            while (iterator.hasNext()) {
                authorities += ((CustomUserDetailsService.OperatorRole) iterator.next()).getAuthority();
            }
            Object data = userService.getUserByUsername(userName);
            message.setData(data);
            message.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
            message.setData("还没有登录");
        }
        return message;
    }


    @RequestMapping("/register")
    public ResponseMessage registerCheck(@RequestBody(required = false) User paramObj) {
        logger.debug("registerCheck paramObj：" + paramObj);
        ResponseMessage message = new ResponseMessage();
        try {
            Boolean flag = userService.insertUser(paramObj);
            if (flag) {
                message.setData(flag);
                message.setMessage("你已成功注册！！！！");
                message.setStatus(true);
            } else {
                message.setData(flag);
                message.setMessage("注册失败！！！！ 该用户名已被注册 ");
                message.setStatus(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message.setStatus(false);
            message.setErrorCode(ErrorCode.DataBaseAccessError);
            message.setMessage(e.toString());
            message.setData("还没有登录");
        }
        return message;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResponseMessage updateUser(@RequestBody(required = false) User user) {
        /**
         * describe: 更新用户
         * class_name: updateUser
         * param: [user]
         * return: cn.edu.gdut.llc.share.response.ResponseMessage
         * creat_user: ZHAN
         * creat_date: 2018/2/17/0017
         * creat_time: 22:29
         **/
        logger.debug("updateUser: user: " + user);
        ResponseMessage message = new ResponseMessage();
        try {
            if (userService.updateUser(user)) {
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


}
