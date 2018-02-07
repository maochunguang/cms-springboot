package com.cms.autoconfig;

import com.cms.listener.WebAppContextListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author maocg
 * Date：2018/2/6
 * Description：添加listener配置
 */
@Configuration
public class ListenerConfiguration {

    @Bean
    public ServletListenerRegistrationBean<WebAppContextListener> testListenerRegistration() {
        ServletListenerRegistrationBean<WebAppContextListener> registration = new ServletListenerRegistrationBean<>(new WebAppContextListener());
        return registration;
    }
}