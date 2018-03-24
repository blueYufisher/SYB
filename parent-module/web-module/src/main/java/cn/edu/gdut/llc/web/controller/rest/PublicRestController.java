package cn.edu.gdut.llc.web.controller.rest;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gdut.llc.mybatis.model.User;
import cn.edu.gdut.llc.share.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.gdut.llc.mybatis.model.Login;
import cn.edu.gdut.llc.share.constant.ErrorCode;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.LoginService;
import cn.edu.gdut.llc.share.util.AutoLogger;

/**
 * 公共接口
 *
 * @author cpt725
 */
@RestController
public class PublicRestController {
    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    /**
     * 验证验证码
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = {"/login.check"}, method = {RequestMethod.POST})
    public ResponseMessage loginCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseMessage responseMessage = new ResponseMessage();
        logger.debug("loginCheck");
        String validateCode = (String) request.getSession().getAttribute("validateCode");
        request.getSession().removeAttribute("validateCode");
        logger.debug("loginCheck-validateCode:" + validateCode);
        String code = request.getParameter("code");
        logger.debug("code:" + code);

        if (!code.equalsIgnoreCase(validateCode)) {
            responseMessage.setStatus(false);
            responseMessage.setErrorCode(ErrorCode.ValidateCodeError);
            responseMessage.setMessage("验证码错误！");
            logger.debug("验证码错误！");
            return responseMessage;
        }

//        String userName = request.getParameter("username");
//        Object user = userService.getUserByUsername(userName);
//        responseMessage.setData(user);
//        responseMessage.setStatus(true);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
        dispatcher.forward(request, response);
        return null;
    }
    
    
    /**
     * 不需要验证验证码
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = {"/checkLogin"}, method = {RequestMethod.POST})
    public ResponseMessage checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseMessage responseMessage = new ResponseMessage();
        logger.debug("loginCheck");
        String validateCode = (String) request.getSession().getAttribute("validateCode");
        request.getSession().removeAttribute("validateCode");
        logger.debug("loginCheck-validateCode:" + validateCode);
        String code = request.getParameter("code");
        logger.debug("code:" + code);

//        if (!code.equalsIgnoreCase(validateCode)) {
//            responseMessage.setStatus(false);
//            responseMessage.setErrorCode(ErrorCode.ValidateCodeError);
//            responseMessage.setMessage("验证码错误！");
//            logger.debug("验证码错误！");
//            return responseMessage;
//        }

//        String userName = request.getParameter("username");
//        Object user = userService.getUserByUsername(userName);
//        responseMessage.setData(user);
//        responseMessage.setStatus(true);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
        dispatcher.forward(request, response);
        return null;
    }

    /**
     * 微信登陆页面
     *
     * @param principal
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/weixin/login.post"}, method = {RequestMethod.POST})
    public String weixinLoginPost(Principal principal,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("weixinLoginPost");

        String weixinCodeBack = (String) request.getSession().getAttribute("weixinCodeBack");
        logger.debug("weixinLoginPost-weixinCodeBack:" + weixinCodeBack);
        String weixinCode = request.getParameter("weixinCode");
        logger.debug("weixinLoginPost-weixinCode:" + weixinCode);
        String username = request.getParameter("username");
        logger.debug("weixinLoginPost-username:" + username);
        if (!weixinCode.equals(weixinCodeBack)) {

            logger.debug("微信授权失败！");
            return "微信授权失败，请用用户名密码登录！";
        }

        User user = userService.getUserByUsername(username);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/login?password=" + user.getPassword());
        dispatcher.forward(request, response);
        return null;
    }
}
