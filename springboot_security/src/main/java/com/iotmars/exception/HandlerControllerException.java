package com.iotmars.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author: xsh
 * @date: 2020/11/27 10:08
 */
@ControllerAdvice
public class HandlerControllerException {


    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException e) {
        if (e instanceof AccessDeniedException) {
            return "redirect:/403.jsp";
        }
        return "redirect:/500.jsp";


    }

}
