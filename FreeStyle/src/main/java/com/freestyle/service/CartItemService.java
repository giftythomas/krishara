package com.freestyle.service;

import java.util.List;

import com.freestyle.model.CartItems;

public interface CartItemService {

public void addCartItem(CartItems cartItem);
	
	public void removeCartItem(CartItems cartItem);
	
	//public void removeAllItems(Cart cart);
	
	public List<CartItems> listCartItems(int cart_id);
	
	public CartItems getCartItemByProductId(int product_id);
}
