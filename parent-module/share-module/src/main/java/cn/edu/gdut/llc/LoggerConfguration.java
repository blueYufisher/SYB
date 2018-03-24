package cn.edu.gdut.llc;

import cn.edu.gdut.llc.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ${DESCRIPTION}
 *
 * @author ZHAN
 * @create 2018-01-14 20:52
 **/
@Configuration
public class LoggerConfguration  extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
    }

}
