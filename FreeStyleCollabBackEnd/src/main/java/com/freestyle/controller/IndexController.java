package com.freestyle.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

	@RequestMapping(method=RequestMethod.GET)
	public String index(){
		return "Server Running.....Good to go!!";
	}
}
