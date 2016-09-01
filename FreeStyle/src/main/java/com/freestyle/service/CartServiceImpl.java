package com.freestyle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freestyle.dao.CartDAO;
import com.freestyle.model.Cart;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDAO cartDAO;
	
	public Cart getCartById(int cart_id) {
		return cartDAO.getCartById(cart_id);
		 
	}

	
	public void updateCart(Cart cart) {
		cartDAO.updateCart(cart);
		
	}


	
	
}
