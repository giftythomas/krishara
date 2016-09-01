package com.freestyle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.freestyle.model.CartItems;
import com.freestyle.model.Product;
import com.freestyle.service.ProductService;

@Controller
public class CartController {

	@Autowired
	ProductService productService;
	@Autowired
	CartItems cartItems;
	@RequestMapping("/userCart")
	public String addToCart(@RequestParam("id") String id){
		Product product=productService.getId(Integer.parseInt(id));
		cartItems.setQuantity(1);
		cartItems.setTotal(product.getProduct_price());
		return "redirect:/User";
	}
}
