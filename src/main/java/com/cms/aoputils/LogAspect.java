package com.cms.aoputils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.homed.clue.workbench.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public * com.bytedance.homed.clue.workbench.controller.*.*(..))")
    public void callInterface() {

    }

    @Around("callInterface()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        Object[] args = pjp.getArgs();
        String params = "";

        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();

        try {
            //获取请求参数集合并进行遍历拼接
            if (args.length > 0) {
                if ("POST".equals(method)) {
                    Object object = args[0];
                    params = JSON.toJSONString(object, SerializerFeature.WriteMapNullValue);
                } else if ("GET".equals(method)) {
                    params = queryString;
                }
                if (null != params) {
                    params = URLDecoder.decode(params, "utf-8");
                }
            }

            // /homed/clue/workbench/region/getAllRegions/接口的日志responseBody太多且固定，没有用处，删掉
            if ("/homed/clue/workbench/region/getAllRegions/".equals(uri)) {
                log.info("employeeId:{},employeeName:{},requestMethod:{},uri:{},params:{},elapsed:{}ms.",
                        RequestContext.getUserId(), RequestContext.getName(), method, uri, params, (endTime - startTime));
            } else {
                log.info("employeeId:{},employeeName:{},requestMethod:{},uri:{},params:{},responseBody:{},elapsed:{}ms.",
                        RequestContext.getUserId(), RequestContext.getName(), method, uri, params,
                        JSON.toJSONString(result, SerializerFeature.WriteMapNullValue), (endTime - startTime));
            }
        } catch (Exception e) {
            log.error("log error !!", e);
        }
        return result;
    }
}
