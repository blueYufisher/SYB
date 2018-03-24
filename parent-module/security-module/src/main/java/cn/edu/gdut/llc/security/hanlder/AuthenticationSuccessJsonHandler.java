/**
 * Create at 2016年5月31日 by cpt725@qq.com
 */
package cn.edu.gdut.llc.security.hanlder;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gdut.llc.mybatis.model.User;
import cn.edu.gdut.llc.share.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import cn.edu.gdut.llc.mybatis.model.Login;
import cn.edu.gdut.llc.mybatis.model.LoginRecord;
import cn.edu.gdut.llc.security.service.CustomUserDetailsService.OperatorRole;
import cn.edu.gdut.llc.security.util.SecurityUtil;
import cn.edu.gdut.llc.share.response.ResponseMessage;
import cn.edu.gdut.llc.share.service.LoginService;
import cn.edu.gdut.llc.share.util.AutoLogger;

/**
 * @author cpt725@qq.com
 */
@Component
public class AuthenticationSuccessJsonHandler implements AuthenticationSuccessHandler {
    @AutoLogger
    private static Logger logger;
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        logger.debug("onAuthenticationSuccess");
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Iterator<?> iterator = userDetails.getAuthorities().iterator();
        String authorities = "";
        while (iterator.hasNext()) {

            authorities += ((OperatorRole) iterator.next()).getAuthority() + " ";
        }
        User user = userService.getUserByUsername(userDetails.getUsername());

        //获取登录ip
        String ip = SecurityUtil.getIpAddress(request);
        Date date = new Date();

        //更新登录次数
        int login_count = user.getLogCount();
        login_count++;

        //更新登录信息
        user.setLogCount(login_count);
        user.setLogTime(date);
        user.setIpAddress(ip);
        userService.updateUser(user);

        //添加登录记录
        LoginRecord loginRecord = new LoginRecord();
        loginRecord.setUsername(user.getUserName());
        loginRecord.setIpAddress(ip);
        loginRecord.setLoginTime(date);
        userService.insertLoginRecord(loginRecord);

        logger.info("username:" + userDetails.getUsername() +
                " ip:" + ip + " 已登陆！"
                + "authorities:" + authorities);
        if (request.getSession().getAttribute("isWeixinLogin") != null && (boolean) request.getSession().getAttribute("isWeixinLogin")) {
            request.getSession().removeAttribute("isWeixinLogin");
            response.sendRedirect("/");
        } else {
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setStatus(true);
            responseMessage.setErrorCode(null);
            responseMessage.setMessage(null);
            responseMessage.setData(user);
            response.setContentType("application/json");
            response.setStatus(200);
            response.getWriter().print(responseMessage.toString());

            response.getWriter().flush();
			/*System.out.println(authorities);
			if(authorities.equals("ROLE_CUSTOMER"))
			{
				response.sendRedirect("/Admin/index.html");
				
			}	
			else
				response.sendRedirect("/");*/
        }
    }
}