package com.fsffrontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fsfbackend.dao.CategoryDAO;
import com.fsfbackend.dao.UserDAO;
import com.fsfbackend.model.Category;
import com.fsfbackend.model.User;

@Controller
public class UserController {

	Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value="username") String username,
				@RequestParam(value="password") String password, HttpSession session){
		log.debug("<-- login method init -->");
		log.info("username is {} password is {}", username, password);
		ModelAndView mv=new ModelAndView("home");
		boolean validUser=userDAO.authenticate(username, password);
		System.out.println(validUser);
		if(validUser==true){
			log.info("<--inside if -->");
			user=userDAO.getByName(username);
			session.setAttribute("loggedInUser", user.getUsername());
			if(user.getAdmin()==1){
				mv.addObject("isAdmin", "true");
			}
			else{
				mv.addObject("isAdmin", "false");
			}
		}
		else{
			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMessage", "Please enter Valid credentials!!");
		}
		log.debug("<-- login method end -->");
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		log.debug("<-- logout method init -->");
		ModelAndView mv = new ModelAndView("home");
		session.invalidate();
		session = request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());
		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");
		log.debug("<-- logout method end -->");
		return mv;
	 }
}
