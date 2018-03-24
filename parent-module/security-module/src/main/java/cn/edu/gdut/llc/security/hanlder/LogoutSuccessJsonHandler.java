/**
 * Create at 2016年6月23日 by cpt725@qq.com
 */
package cn.edu.gdut.llc.security.hanlder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import cn.edu.gdut.llc.share.response.ResponseMessage;

/**
 * @author cpt725@qq.com
 *
 */
@Component
public class LogoutSuccessJsonHandler implements LogoutSuccessHandler {
	@Autowired
	private Environment env;
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		ResponseMessage responseMessage=new ResponseMessage();
		try {
			
			responseMessage.setStatus(true);
			responseMessage.setErrorCode(null);
			responseMessage.setMessage(null);
			
			response.setContentType("application/json");
			response.setStatus(200);
			response.getWriter().print(responseMessage.toString());
		} catch (Exception e) {
			response.setContentType("application/json");
			responseMessage.setStatus(false);
			response.setStatus(500);
			response.getWriter().print(e.toString());
		}

		response.getWriter().flush();
	}

}
