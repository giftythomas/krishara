package com.freestyle.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freestyle.model.Supplier;
@Repository
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionFactory;
	public void addSupplier(Supplier supplier) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.save(supplier);
		tx.commit();
	}

	
	@SuppressWarnings("unchecked")
	public List<Supplier> listSupplier() {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Supplier> list=session.createCriteria(Supplier.class).list();
		return list;
	}

	
	public void deleteSupplier(int id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Supplier supplier=session.get(Supplier.class, new Integer(id));
		session.delete(supplier);
		tx.commit();
	}

	
	@SuppressWarnings("unused")
	public Supplier getSupplier(int id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Supplier supplier=session.get(Supplier.class, new Integer(id));
		return supplier;
	}

}
