package com.freestyle.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freestyle.model.Product;
@Repository
public class ShoeDAOImpl implements ShoeDAO {

	@Autowired
	SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	public List<Product> getByCategory(String category) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<Product> list=session.createCriteria(Product.class)
				.add(Restrictions.like("category", category)).list();
		return list;
	}

	

}
