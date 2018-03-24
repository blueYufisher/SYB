package cn.edu.gdut.llc.interceptor;

import cn.edu.gdut.llc.mybatis.model.LoggerInfos;
import cn.edu.gdut.llc.share.dao.LoggerInfosDao;
import cn.edu.gdut.llc.share.dao.impl.LoggerInfosDaoImpl;
import cn.edu.gdut.llc.share.service.LoggerInfosService;
import cn.edu.gdut.llc.share.util.LoggerUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-14 19:52
 **/
@Component
public class LoggerInterceptor implements HandlerInterceptor {

    @Autowired
    @Qualifier("loggerInfosServiceImpl")
    private LoggerInfosService loggerInfosService;

    //请求开始时间标识
    private static final String LOGGER_SEND_TIME = "_send_time";
    //请求日志实体标识
    private static final String LOGGER_ENTITY = "_logger_entity";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        LoggerInfos loggerInfos = new LoggerInfos();
        //获取请求sessionId
        String sessionId = request.getRequestedSessionId();
        //请求路径
        String url = request.getRequestURI();
        //获取请求参数信息
        String paramData = JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        //设置客户端ip
        loggerInfos.setClientIp(LoggerUtils.getCliectIp(request));
        //设置请求方法
        loggerInfos.setMethod(request.getMethod());
        //设置请求类型（json|普通请求）
        loggerInfos.setCategory(LoggerUtils.getRequestType(request));
        //设置请求参数内容json字符串
        loggerInfos.setParamData(paramData);
        //设置请求地址
        loggerInfos.setUri(url);
        //设置sessionId
        loggerInfos.setSessionId(sessionId);
        //设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());
        //设置请求实体到request内，方面afterCompletion方法调用
        request.setAttribute(LOGGER_ENTITY, loggerInfos);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        //获取请求错误码
        int status = response.getStatus();
        //当前时间
        long currentTime = System.currentTimeMillis();
        //请求开始时间
        long time = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        //获取本次请求日志实体
        LoggerInfos loggerInfos = (LoggerInfos) request.getAttribute(LOGGER_ENTITY);
        //设置请求时间差
        loggerInfos.setTimeConsuming(Integer.valueOf((currentTime - time)+""));
        //设置返回时间
        loggerInfos.setReturnTime(currentTime + "");
        //设置返回错误码
        loggerInfos.setHttpStatusCode(status+"");
//        //设置返回值
        loggerInfos.setReturnData(JSON.toJSONString(request.getAttribute(LoggerUtils.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        //执行将日志写入数据库
        LoggerInfosDaoImpl loggerInfosDao = getDAO(LoggerInfosDaoImpl.class,request);
        loggerInfosDao.saveLoggerInfos(loggerInfos);
    }

    /**
     * 根据传入的类型获取spring管理的对应dao
     *
     * @param clazz   类型
     * @param request 请求对象
     * @param <T>
     * @return
     */
    private <T> T getDAO(Class<T> clazz, HttpServletRequest request) {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }

}
