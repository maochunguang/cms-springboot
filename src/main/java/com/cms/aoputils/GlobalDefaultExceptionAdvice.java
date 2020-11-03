package com.cms.aoputils;

import com.cms.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;

@ControllerAdvice
public class GlobalDefaultExceptionAdvice {

    private final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ModelAndView errorHandler(Exception ex) {
        logger.warn("Exception:", ex);
        return  new ModelAndView();
    }

    @ResponseBody
    @ExceptionHandler(value = {HttpMessageNotReadableException.class, ServletException.class,})
    public ModelAndView paramErrorHandler(Exception ex) {
        logger.warn("PARAM_ERR:", ex);
        return new ModelAndView();
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ModelAndView paramErrorHandler(MethodArgumentNotValidException ex) {
        logger.info("MethodArgumentNotValidException:", ex);
        return new ModelAndView();
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public ModelAndView paramErrorHandler(BindException ex) {
        logger.info("BindException:", ex);
        return new ModelAndView();
    }

    private String getParamErr(BindingResult bindingResult) {
        StringBuilder sb = new StringBuilder();
        for (FieldError error : bindingResult.getFieldErrors()) {
            sb.append(error.getDefaultMessage());
            sb.append(". ");
        }
        return sb.toString();
    }

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ModelAndView errorHandler(BusinessException ex) {
        logger.info("BusinessException ", ex);
        return new ModelAndView();
    }
}
