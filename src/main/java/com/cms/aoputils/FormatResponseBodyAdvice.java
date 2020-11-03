//package com.cms.aoputils;
//
//import com.bytedance.homed.clue.workbench.model.ResponseDTO;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//import springfox.documentation.spring.web.json.Json;
//
//
//@ControllerAdvice
//public class FormatResponseBodyAdvice implements ResponseBodyAdvice {
//
//    @Override
//    public boolean supports(MethodParameter returnType, Class converterType) {
//        return true;
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
//                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//
//        if (!(body instanceof ResponseDTO) && !(body instanceof Json)) {
//            return new ResponseDTO<>(body);
//        }
//
//        return body;
//
//    }
//}