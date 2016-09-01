package com.freestyle.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freestyle.model.CartItems;

@Repository
public class CartItemsDAOImpl implements CartItemsDAO {

	@Autowired
	SessionFactory sessionFactory;
	public void addCartItem(CartItems cartItem) {
		System.out.println("in addCartItem");
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(cartItem);
		tx.commit();
		System.out.println("Item added to cart");
	}

	
	public void removeCartItem(CartItems cartItem) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.delete(cartItem);
		tx.commit();
	}


	/*public void removeAllItems(Cart cart) {
		
		
	}*/

	
	public CartItems getCartItemByProductId(int product_id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		String hql="from CartItems where product_id="+product_id;
		Query query=  session.createQuery(hql);
		CartItems cartItems= (CartItems) query.uniqueResult();
		tx.commit();
		return cartItems;
		
	}


	@SuppressWarnings({ "unchecked", "unused" })
	public List<CartItems> listCartItems(int cart_id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Query query= session.createQuery("from CartItems where cart_id="+cart_id);
		List<CartItems> list=(List<CartItems>)query.list();
		return list;
	}

}
