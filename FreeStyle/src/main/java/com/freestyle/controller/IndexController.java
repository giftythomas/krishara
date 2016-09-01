package com.freestyle.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.freestyle.model.Product;
import com.freestyle.model.User;
import com.freestyle.service.ProductService;
import com.freestyle.service.UserService;

@Controller
public class IndexController {
	@Autowired
	User user;
	@Autowired
	UserService service;
	@Autowired
	ProductService productService;
	@Autowired
	SessionFactory sessionFactory;
	//request mapping for the first page
	@RequestMapping("/")
	public ModelAndView indexLoad(){
		System.out.println("Starting of method indexLoad()");
		return new ModelAndView("index");
	}
	@RequestMapping("/index")
	public ModelAndView index(){
		return new ModelAndView("index");
	}
	//when user clicks on register, this method will be executed
	@RequestMapping("/register")
	public ModelAndView register(){
		System.out.println("register method");
		ModelAndView mv= new ModelAndView("register");
		mv.addObject("user", user);
		return mv;
	}
	//when the user clicks on submit, the fields which are given are pushed into db
	@RequestMapping(value="/reg", method=RequestMethod.POST)
	public ModelAndView reg(@Valid@ModelAttribute User user, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("register");
		}
		service.addUser(user);
		System.out.println("Done saving");
		return new ModelAndView("login","success","\"Successfully registered!!\"");
	}
	@RequestMapping("/User")
	public ModelAndView userCheck(Principal principal) throws JsonGenerationException, JsonMappingException, IOException{
		System.out.println("user login");
		List<Product> list = productService.viewProduct();
		ObjectMapper object = new ObjectMapper();
		String jsonlist = object.writeValueAsString(list);
		return new ModelAndView("test1","listofproducts",jsonlist);
	}
	@RequestMapping("/productDetails")
	public ModelAndView productDetails(@RequestParam("id") String id){
		Product product=productService.getId(Integer.parseInt(id));
		return new ModelAndView("test","products",product);
	}
	@RequestMapping("/Admin")
	public ModelAndView adminCheck(Principal principal){
		
		return new ModelAndView("adminHome");
	}
	//Mapping login
	@RequestMapping("/login")
	public String loginMethod()
	{
		return "/login";
	}
	//Mapping logout
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request)
	{
		request.getSession().invalidate();
		return new ModelAndView("redirect:/index");
		
	}
	
}
