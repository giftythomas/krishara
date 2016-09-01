package com.freestyle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.freestyle.model.Supplier;
import com.freestyle.model.User;
import com.freestyle.service.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	@Autowired
	Supplier supplier;
	@RequestMapping("/supplier")
	public ModelAndView register(){
		System.out.println("supplier method");
		ModelAndView mv= new ModelAndView("supplier");
		mv.addObject("supplier", supplier);
		return mv;
	}
	
	@RequestMapping(value="/addSupplier", method=RequestMethod.POST)
	public ModelAndView reg(@Valid@ModelAttribute Supplier supplier, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("supplier");
		}
		supplierService.addSupplier(supplier);
		System.out.println("Done saving");
		return new ModelAndView("supplier","done","\"Supplier added successfully!!\"");
	}
}
