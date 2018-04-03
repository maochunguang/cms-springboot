package com.cms.autoconfig;

import com.cms.filter.LoginFilter;
import com.cms.filter.StartFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author maocg
 * Date：2018/2/6
 * Description：TODO
 */
@Configuration
public class FilterConfiguration {
    @Bean("startFilter")
    public FilterRegistrationBean startFilterRegistration() {

        FilterRegistrationBean start = new FilterRegistrationBean();
        start.setFilter(new StartFilter());
        start.setName("startFilter");
        start.setOrder(1);
        return start;
    }
    @Bean("loginFilter")
    public FilterRegistrationBean loginFilterRegistration() {

        FilterRegistrationBean login = new FilterRegistrationBean();
        login.setFilter(new LoginFilter());
        login.setName("loginFilter");
        login.addUrlPatterns("/*");
        login.setOrder(2);
        return login;
    }
}