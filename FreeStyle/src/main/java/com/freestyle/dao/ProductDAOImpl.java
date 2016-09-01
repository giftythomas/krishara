package com.freestyle.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.freestyle.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void addProduct(Product product) {
		System.out.println("ProductDAOImpl");
		Session session = sessionFactory.getCurrentSession();
		System.out.println("product name:"+product.getProduct_name());
		Transaction tx= session.beginTransaction();
		System.out.println(session);
		session.save(product);
		System.out.println("Item added");
		tx.commit();
	}

	public List<Product> viewProduct() {
		Session session= sessionFactory.getCurrentSession();
		@SuppressWarnings("unused")
		Transaction transaction=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Product>list= session.createCriteria(Product.class).list();
		return list;
	}


	public void deleteProduct(int id) {
		Session session= sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Product product=session.get(Product.class, new Integer(id));
	    session.delete(product);
	    transaction.commit();
	    System.out.println("deleted"+product.getProduct_name());
	}

	public Product getId(int id) {
		Session session= sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Product product=session.get(Product.class, new Integer(id));
		transaction.commit();
		System.out.println("Got the Product");
		return product;
	}


	public void updateProduct(Product product) {
		Session session= sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.update(product);
		transaction.commit();
		
	}

}
