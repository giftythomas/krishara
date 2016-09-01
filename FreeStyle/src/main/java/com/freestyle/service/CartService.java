package com.freestyle.service;

import com.freestyle.model.Cart;

public interface CartService {

	public Cart getCartById(int cart_id);

	public void updateCart(Cart cart);

}
