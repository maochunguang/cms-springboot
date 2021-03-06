package com.cms.filter;

import com.cms.controller.system.BaseController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mao
 */
public class LoginFilter extends BaseController implements Filter {

    /**
     * 初始化
     */
    @Override
    public void init(FilterConfig fc) throws ServletException {
        //FileUtil.createDir("d:/FH/topic/");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        chain.doFilter(request, response);
    }

}
