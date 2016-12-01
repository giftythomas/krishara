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

import com.fsfbackend.model.User;
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	 static Logger log=LoggerFactory.getLogger(UserDAOImpl.class);
	
	public UserDAOImpl(SessionFactory sessionFactory){
		log.debug("<-- Entering sessionFactory -->");
		try {
			this.sessionFactory=sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- Exiting sessionFactory -->");
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> list() {
		log.debug("<-- List method init -->");
		List<User> list=sessionFactory.getCurrentSession().createCriteria(User.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("<-- List method end -->");
		return list;
	}

	@Transactional
	public boolean saveOrUpdate(User user) {
		log.debug("<-- SaveorUpdate method init -->");
		try {
			user.setEnabled(true);
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- SaveorUpdate method end -->");
		return false;
	}

	@Transactional
	public void delete(int id) {
		log.debug("<-- delete method init -->");
		try {
			User user= new User();
			user.setId(id);;
			sessionFactory.getCurrentSession().delete(user);
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- delete method end -->");
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public User get(int id) {
		log.debug("<-- get method init -->");
		try {
			String hql="from User where id="+id;
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<User> list=(List<User>)query.list();
			if(list!=null && list.isEmpty()){
				return list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- get method end -->");
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public boolean authenticate(String name, String password) {
		log.debug("Entering authenticate method");
		try {
			String hql = "from User where username= '" + name + "' and " + " password ='" + password+"'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<User> list=(List<User>)query.list();
			if(list!=null && !list.isEmpty()){
				return true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("Exiting authenticate method");
		return false;
	}

	@Transactional
	public User getByName(String name) {
		log.debug("<-- getByName method init -->");
			String hql="from User where username='"+name+"'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			User user=(User) query.uniqueResult();
		log.debug("<-- getByName method end -->");
		return user;
	}

}
