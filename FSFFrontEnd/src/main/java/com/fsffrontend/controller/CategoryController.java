package com.fsffrontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.fsfbackend.dao.CategoryDAO;
import com.fsfbackend.model.Category;
import com.fsfbackend.util.Util;

@Controller
public class CategoryController {

	private static final Logger log=LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	private Category category;
	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public String listCategories(Model model){
		log.debug("<-- listCategories method init -->");
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());
		log.debug("<-- listCategories method end -->");
		return "category";
	}
	@RequestMapping(value="/category/add", method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category){
		log.debug("<-- addCategory method init -->");
		Util u=new Util();
		String id=u.replace(category.getCatName(), ",", "");
		category.setCatName(id);
		log.debug("<-- addCategory method init -->");
		return "categories";
	}
	@RequestMapping(value="/category/remove/{id}" )
	public String removeCategory(@PathVariable("id") int id, ModelMap model) throws Exception{
		log.debug("<-- removeCategory method init -->");
		try {
			categoryDAO.delete(id);
			model.addAttribute("message", "Successfully deleted!!");
		} catch (Exception e) {
			model.addAttribute("message",e.getMessage());
			log.error(e.getMessage());
		}
		log.debug("<-- removeCategory method end -->");
		return "redirect:/category";
	}
	
	public String editCategory(@PathVariable("id") int id, Model model){
		log.debug("<-- editCategory method init -->");
		model.addAttribute("category", this.categoryDAO.get(id));
		model.addAttribute("listCategory", this.categoryDAO.list());
		log.debug("<-- editCategory method init -->");
		return "category";
	}
}
