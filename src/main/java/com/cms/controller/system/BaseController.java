package com.cms.controller.system;


import com.cms.entity.system.Page;
import com.cms.util.MyLogger;
import com.cms.util.PageData;
import com.cms.util.UuidUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author maocg
 * @date 2016/10/27
 */
public class BaseController {
	
	protected MyLogger myLogger = MyLogger.getLogger(this.getClass());


    public PageData getPageData(){
		return new PageData(this.getRequest());
	}


    public ModelAndView getModelAndView(){
		return new ModelAndView();
	}


    public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}


    public String get32UUID(){
		
		return UuidUtil.get32UUID();
	}


    public Page getPage(){
		
		return new Page();
	}
	
	public static void logBefore(MyLogger myLogger, String interfaceName){
		myLogger.info("");
		myLogger.info("start");
		myLogger.info(interfaceName);
	}
	
	public static void logAfter(MyLogger myLogger){
		myLogger.info("end");
		myLogger.info("");
	}

}
