package com.fsfbackend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fsfbackend.model.Supplier;
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger log=LoggerFactory.getLogger(SupplierDAOImpl.class);
	
	public SupplierDAOImpl(SessionFactory sessionFactory) {
		log.debug("<-- SessionFactory init -->");
		try {
			this.sessionFactory=sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- SessionFactory end -->");
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Supplier> list() {
		log.debug("<-- SupList method init -->");
		List<Supplier> list=sessionFactory.getCurrentSession().createCriteria(Supplier.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("<-- SupList method end -->");
		return list;
	}

	@Transactional
	public void saveOrUpdate(Supplier supplier) {
		log.debug("<-- SupSave method init -->");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- SupSave method end -->");
	}

	@Transactional
	public void delete(int id) {
		log.debug("<-- SupDelete method init -->");
		try {
			Supplier supplier=new Supplier();
			supplier.setSupId(id);
			sessionFactory.getCurrentSession().delete(supplier);
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- SupDelete method end"
				+ " -->");
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Supplier get(int id) {
		log.debug("<-- SupGet method init -->");
		try {
			String hql="from Supplier where supId="+id;
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<Supplier> list=(List<Supplier>)query.list();
			if(list!=null && list.isEmpty()){
				return list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- SupGet method end -->");
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Supplier getByName(String name) {
		log.debug("<-- SupGetByName method init -->");
		try {
			String hql="from Supplier where supId="+"'"+name+"'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<Supplier> list=(List<Supplier>)query.list();
			if(list!=null && list.isEmpty()){
				return list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- SupGetByName method end -->");
		return null;
	}

}
