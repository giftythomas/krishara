package com.freestyle.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.freestyle.model.Product;
import com.freestyle.service.ShoeService;

@Controller
public class ShoeController {

	@Autowired
	ShoeService service;
	
	@RequestMapping("/goToCategory")
	public ModelAndView listNike(@RequestParam("category") String category) throws JsonGenerationException, JsonMappingException, IOException{
		List<Product> list=service.getByCategory(category);
		ObjectMapper mapper= new ObjectMapper();
		String listJSON=mapper.writeValueAsString(list);
		System.out.println("list is"+listJSON);
		return new ModelAndView("category", "categories", listJSON);
	}
	
}
