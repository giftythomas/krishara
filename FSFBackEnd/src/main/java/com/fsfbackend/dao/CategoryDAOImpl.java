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

import com.fsfbackend.model.Category;
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger log=LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		log.debug("<-- Entering sessionFactory -->");
		try {
			this.sessionFactory=sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- Exiting sessionFactory -->");
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Category> list() {
		log.debug("<-- catList method init -->");
		List<Category> list=sessionFactory.getCurrentSession().createCriteria(Category.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("<-- catList method end -->");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Category get(int id) {
		log.debug("<-- catget method init -->");
		try {
			String hql="from Category where catId="+id;
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<Category> list=(List<Category>)query.list();
			if(list!=null && list.isEmpty()){
				return list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- catget method end -->");
		return null;
	}

	@Transactional
	public boolean saveOrUpdate(Category category) {
		log.debug("<-- catsave method init -->");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- catsave method end -->");
		return false;
	}

	@Transactional
	public void delete(int id) {
		log.debug("<-- catDelete method init -->");
		try {
			Category category=new Category();
			category.setCatId(id);
			sessionFactory.getCurrentSession().delete(category);
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- catDelete method end -->");
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Category getByName(String name) {
		log.debug("<-- catGetByName method init -->");
		try {
			String hql="from Category where catName="+"'"+name+"'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<Category> list=(List<Category>)query.list();
			if(list!=null && list.isEmpty()){
				return list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- catGetByName method end -->");
		return null;
	}

}
