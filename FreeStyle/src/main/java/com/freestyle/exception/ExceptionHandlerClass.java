package com.freestyle.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
@ControllerAdvice
public class ExceptionHandlerClass {

	private static Logger log= LoggerFactory.getLogger(ExceptionHandlerClass.class);
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public ModelAndView IOExceptionHandler(HttpServletRequest request, Exception e){
		log.error("IO Exception occured:: Exception "+e.getMessage());
		ModelAndView mv= new ModelAndView("/404");
		return mv;
	}
}
