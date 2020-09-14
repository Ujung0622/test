package com.spring.mvc.ex06;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class CommonExceptionHandler {

	//@ExceptionHandler(RuntimeException.class)
	@ExceptionHandler(Throwable.class)
	public String handleException(Throwable ex, HttpServletRequest request) {
		//return "error/commonException";
		System.out.println("==============>> Error:"+ClassUtils.getShortName(ex.getClass()));
		return ClassUtils.getShortName(ex.getClass());
	}
}
