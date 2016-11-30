package com.fsffrontend.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fsfbackend.dao.CategoryDAO;
import com.fsfbackend.dao.UserDAO;
import com.fsfbackend.model.Category;
import com.fsfbackend.model.User;

@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private User user;

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;
	
	@RequestMapping("/")
	public ModelAndView home(HttpSession session){
		log.debug("<-- home method init -->");
		ModelAndView mv=new ModelAndView("home");
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());
		log.debug("<-- home method end -->");
		return mv;
	}
	@RequestMapping("/registerHere")
	public ModelAndView registerHere(){
		log.debug("<-- registerHere method init -->");
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("user", new User());
		mv.addObject("userClickedRegisterHere", "true");
		log.debug("<-- registerHere method end -->");
		return mv;
	}
	@RequestMapping(value="user/register", method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute User user){
		log.debug("<-- register method init -->");
		userDAO.saveOrUpdate(user);
		ModelAndView mv= new ModelAndView("home");
		mv.addObject("success", "You're successfully registered!!");
		log.debug("<-- register method end -->");
		return mv;
	}
	@RequestMapping("/loginHere")
	public ModelAndView loginHere(){
		log.debug("<-- loginHere method init -->");
		ModelAndView mv= new ModelAndView("home");
		mv.addObject("user", user);
		mv.addObject("userClickedLoginHere", "true");
		log.debug("<-- loginHere method end -->");
		return mv;
	}
}
