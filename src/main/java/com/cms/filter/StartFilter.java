package com.cms.filter;

import com.cms.controller.system.BaseController;

import javax.servlet.*;
import java.util.Calendar;

/**
 * @author maocg
 * 创建时间：2014年2月17日
 */
public class StartFilter extends BaseController implements Filter {
    @Override
    public void init(FilterConfig fc) {
    }

    /**
     *定时任务
     */
    public void timer() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

    }


    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }


    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) {
        // TODO Auto-generated method stub

    }


}
