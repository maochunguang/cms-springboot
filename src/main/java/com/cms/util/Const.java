package com.cms.util;

import org.springframework.context.ApplicationContext;

/**
 * 项目名称：
 *
 * @authorfh
 */
public class Const {
    public static final String SESSION_SECURITY_CODE = "sessionSecCode";
    public static final String SESSION_USER = "sessionUser";
    public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
    public static final String SESSION_menuList = "menuList";
    public static final String SESSION_allmenuList = "allmenuList";
    public static final String SESSION_QX = "QX";
    public static final String SESSION_userpds = "userpds";
    public static final String SESSION_USERROL = "USERROL";
    public static final String SESSION_USERNAME = "USERNAME";

    public static final String LOGIN = "/login_toLogin.do";
    public static final String SYSNAME = "admin/config/SYSNAME.txt";
    public static final String PAGE = "admin/config/PAGE.txt";
    public static final String EMAIL = "admin/config/EMAIL.txt";
    public static final String SMS1 = "admin/config/SMS1.txt";
    public static final String SMS2 = "admin/config/SMS2.txt";
    public static final String FWATERM = "admin/config/FWATERM.txt";
    public static final String IWATERM = "admin/config/IWATERM.txt";
    public static final String WEIXIN = "admin/config/WEIXIN.txt";
    public static final String FILEPATHIMG = "uploadFiles/uploadImgs/";
    public static final String FILEPATHFILE = "uploadFiles/file/";
    public static final String FILEPATHTWODIMENSIONCODE = "uploadFiles/twoDimensionCode/";
    /**
     * 不对匹配该值的访问路径拦截（正则）
     */
    public static final String NO_INTERCEPTOR_PATH = ".*/((login_toLogin)|(wx)|((login_login))|(logout)|(code)|(app)|(weixin)|(pay)|(static)|(main)|(websocket)).*";


    public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化


    /**
     * app注册接口_请求协议参数)
     */

    public static final String[] APP_REGISTERED_PARAM_ARRAY = new String[]{"countries", "uname", "passwd", "title", "full_name", "company_name", "countries_code", "area_code", "telephone", "mobile"};
    public static final String[] APP_REGISTERED_VALUE_ARRAY = new String[]{"国籍", "邮箱帐号", "密码", "称谓", "名称", "公司名称", "国家编号", "区号", "电话", "手机号"};

    /**
     * app根据用户名获取会员信息接口_请求协议中的参数
     */
    public static final String[] APP_GETAPPUSER_PARAM_ARRAY = new String[]{"USERNAME"};
    public static final String[] APP_GETAPPUSER_VALUE_ARRAY = new String[]{"用户名"};


}
