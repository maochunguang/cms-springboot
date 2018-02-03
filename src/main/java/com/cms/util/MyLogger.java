package com.cms.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author maocg
 * description: log4j日志类
 */
public class MyLogger {

    private Logger logger;


    /**
     * 构造方法，初始化Log4j的日志对象
     */
    private MyLogger(Logger log4jLogger) {
        logger = log4jLogger;
    }

    /**
     * 获取构造器，根据类初始化Logger对象
     *
     * @param classObject Class对象
     * @return Logger对象
     */
    public static MyLogger getLogger(Class classObject) {
        return new MyLogger(LoggerFactory.getLogger(classObject));
    }

    /**
     * 获取构造器，根据类名初始化Logger对象
     *
     * @param loggerName 类名字符串
     * @return Logger对象
     */
    public static MyLogger getLogger(String loggerName) {
        return new MyLogger(LoggerFactory.getLogger(loggerName));
    }

    public void debug(String str) {
        logger.debug(str);
    }

    public void debug(String str, Throwable e) {
        logger.debug(str, e);
    }

    public void info(String str) {
        logger.info(str);
    }

    public void info(String str, Throwable e) {
        logger.info(str, e);
    }

    public void warn(String str) {
        logger.warn(str);
    }

    public void warn(String str, Throwable e) {
        logger.warn(str, e);
    }

    public void error(String str) {
        logger.error(str);
    }

    public void error(String str, Throwable e) {
        logger.error(str, e);
    }

    public String getName() {
        return logger.getName();
    }

    public Logger getLog4jLogger() {
        return logger;
    }

    public boolean equals(MyLogger newMyLogger) {
        return logger.equals(newMyLogger.getLog4jLogger());
    }
}