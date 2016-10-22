package com.collaboration.controller;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.collaboration.model.Message;
import com.collaboration.model.OutputMessage;
import com.collaboration.model.User;
import com.collaboration.service.UserService;

@Controller
public class HomeController
{
	
	@Autowired
	UserService userserivce;

	ModelAndView mv;
	
	@RequestMapping("/")
	public ModelAndView LandPage()
	{
		mv = new ModelAndView("LandingPage");
		return mv;
	}
	
	@RequestMapping("/reg")
	public ModelAndView RegPage()
	{
		mv = new ModelAndView("Registration");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView LoginP()
	{
		mv = new ModelAndView("LoginPage");
		return mv;
	}
	
	
	@RequestMapping("/register")
	public String createUser(@ModelAttribute("user") User user , Model model,HttpServletRequest request, MultipartFile file) throws IOException
	{
		
		String filename = null;
	    byte[] bytes;
	    
	    		user.setRole("ROLE_USER");
	    		user.setEnabled(true);
	            userserivce.saveOrUpdate(user);
	    		System.out.println("Data Inserted");
	            //String path = request.getSession().getServletContext().getRealPath("/resources/images/" + user.getUserid() + ".jpg");
	    		MultipartFile image = user.getImage();
	            //Path path;
	            String path = request.getSession().getServletContext().getRealPath("/resources/images/"+user.getUserid()+".jpg");
	            System.out.println("Path="+path);
	            System.out.println("File name = " + user.getImage().getOriginalFilename());
	          
	            if(image!=null && !image.isEmpty())
	            {
	            	try
	            	{
	            		image.transferTo(new File(path.toString()));
	            		System.out.println("Image saved  in:"+path.toString());
	            	}
	            	catch(Exception e)
	            	{
	            		e.printStackTrace();
	            		System.out.println("Image not saved");
	            	}
	            }
	    	
	     	    
	    return "LoginPage";
	
		
	}
	@ModelAttribute("user")
	public  User returnObject()
	{
		return new User();
	}
	

	@RequestMapping("/Chat")
	  public String viewApplication() 
	{
			System.out.println("i am in controller");
	    return "ChatPage";
	  }
	    
	  @MessageMapping("/chat")
	  @SendTo("/topic/message")
	  public OutputMessage sendMessage(Message message) {
	    return new OutputMessage(message, new Date());
	  }
	  
	  @RequestMapping("/home")
	   public ModelAndView HomePageapp()
	  {
		  mv = new  ModelAndView("Home");
		  return mv;
	  }
	  
	  @RequestMapping("/newwall")
	  public ModelAndView WallPageapp(Principal p)
	  {
		 System.out.println(p);
		  	System.out.println("Name:"+p.getName());
		  	User user = userserivce.getUserByname(p.getName());
		  	int id = user.getUserid();
		  	User user1 = userserivce.getUserById(id);
		  	System.out.println("user info="+user1);
		  	
		   mv = new ModelAndView("wallpage","walldata",user1);

		  System.out.println("i am in wall");
		  return mv;
	  }
	  
}
