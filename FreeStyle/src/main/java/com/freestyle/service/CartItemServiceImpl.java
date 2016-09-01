package com.freestyle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freestyle.dao.CartItemsDAO;
import com.freestyle.model.CartItems;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	CartItemsDAO cartItemsDAO;
	public void addCartItem(CartItems cartItem) {
		cartItemsDAO.addCartItem(cartItem);
	}

	
	public void removeCartItem(CartItems cartItem) {
		cartItemsDAO.removeCartItem(cartItem);
	}

	
	public CartItems getCartItemByProductId(int product_id) {
		return cartItemsDAO.getCartItemByProductId(product_id); 
		
	}


	public List<CartItems> listCartItems(int cart_id) {
		List<CartItems> list=cartItemsDAO.listCartItems(cart_id);
		return list;
	}

	
}
