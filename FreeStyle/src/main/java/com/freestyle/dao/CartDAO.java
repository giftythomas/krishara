package com.freestyle.dao;

import com.freestyle.model.Cart;

public interface CartDAO {

	public Cart getCartById(int cart_id);
	
	public void updateCart(Cart cart);
	
	public Cart validateCart(int cart_id);
}
