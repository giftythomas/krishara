package com.freestyle.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.freestyle.model.Cart;
import com.freestyle.model.CartItems;
import com.freestyle.model.Product;
import com.freestyle.model.User;
import com.freestyle.service.CartItemService;
import com.freestyle.service.CartService;
import com.freestyle.service.ProductService;
import com.freestyle.service.UserService;

@Controller
public class CartController {

	@Autowired
	ProductService productService;
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemService cartItemService;
	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;
	@RequestMapping(value="/userCart")
	public String addToCart(@RequestParam(value="product_id") int product_id, @AuthenticationPrincipal org.springframework.security.core.userdetails.User activeUser){
		User user=userService.getUserByName(activeUser.getUsername());
		Cart cart=user.getCart();
		Product product=productService.getId(product_id);
		List<CartItems> list=cart.getCartItems();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Inside for loop");
			if(product.getProduct_id()==list.get(0).getProduct().getProduct_id()){
				System.out.println("Inside if ");
				CartItems cartItems=list.get(i);
				cartItems.setQuantity(cartItems.getQuantity()+1);
				System.out.println("Quantity updated");
				cartItems.setTotal(product.getProduct_price()*cartItems.getQuantity());
				cartItemService.addCartItem(cartItems);
				System.out.println("Product added");
				return "redirect:/User";
			}
		}
		
		cartItems.setCart(cart);
		cartItems.setProduct(product);
		cartItems.setQuantity(1);
		cartItems.setTotal(product.getProduct_price()*cartItems.getQuantity());
		cartItemService.addCartItem(cartItems);
		return "redirect:/User";
	}
	@RequestMapping("/viewCart")
	public ModelAndView viewCart() throws JsonGenerationException, JsonMappingException, IOException{
		String activeUser=SecurityContextHolder.getContext().getAuthentication().getName();
		User actUser=userService.getUserByName(activeUser);
		Cart cart=actUser.getCart();
		int cart_id=cart.getCart_id();
		List<CartItems> list=cartItemService.listCartItems(cart_id);
		ObjectMapper map=new ObjectMapper();
		String jsonList=map.writeValueAsString(list);
		double totalAmount=cartService.totalAmount(cart_id);
		ModelAndView mv= new ModelAndView("cart");
		mv.addObject("CartItems", jsonList);
		mv.addObject("totalAmount", totalAmount);
		return mv;
	}
	
	@RequestMapping("/deleteCartItem")
	public String deleteSingleCartItems(@RequestParam("id") int id){
		cartItemService.removeCartItem(cartItems);
		return "redirect:/viewCart";
	}
	
}
