package com.freestyle.dao;

import com.freestyle.model.CartItems;

public interface CartItemsDAO {

	public void addCartItem(CartItems cartItem);
	
	public void removeCartItem(CartItems cartItem);
	
	//public void removeAllItems(Cart cart);
	
	public CartItems getCartItemByProductId(int product_id);
}
