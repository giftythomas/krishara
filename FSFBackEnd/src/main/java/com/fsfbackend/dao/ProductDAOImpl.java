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

import com.fsfbackend.model.Product;
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger log=LoggerFactory.getLogger(ProductDAOImpl.class);
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
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
	public List<Product> list() {
		log.debug("<-- ProList method init -->");
		List<Product> list=sessionFactory.getCurrentSession().createCriteria(Product.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("<-- ProList method end -->");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Product get(int id) {
		log.debug("<-- ProGet method init -->");
		try {
			String hql="from Product where proId="+id;
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<Product> list=(List<Product>)query.list();
			if(list!=null && list.isEmpty()){
				return list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- ProGet method end -->");
		return null;
	}

	@Transactional
	public boolean saveOrUpdate(Product product) {
		log.debug("<-- ProSave method init -->");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- ProSave method end -->");
		return false;
	}

	@Transactional
	public void delete(int id) {
		Product product=new Product();
		product.setProId(id);
		sessionFactory.getCurrentSession().delete(product);

	}

}
