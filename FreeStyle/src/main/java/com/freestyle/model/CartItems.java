package com.freestyle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Entity
@Component
public class CartItems {

	@Id@GeneratedValue
	private int cartItem_id;
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	private int quantity;
	private double total;
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getCartItem_id() {
		return cartItem_id;
	}
	public void setCartItem_id(int cartItem_id) {
		this.cartItem_id = cartItem_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
