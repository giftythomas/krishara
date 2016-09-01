package com.freestyle.dao;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freestyle.model.Cart;

@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;
	public Cart getCartById(int cart_id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Cart cart=(Cart) session.get(Cart.class, cart_id);
		tx.commit();
		System.out.println("done saving");
		return cart;
	}

	public void updateCart(Cart cart) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(cart);
		tx.commit();
		
	}

	
	public Cart validateCart(int cart_id) {
		Cart cart=getCartById(cart_id);
		if(cart==null || cart.getCartItems().size()==0){
			try {
				throw new IOException(cart_id+"");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		updateCart(cart);
		return cart;
	}

}
