package com.freestyle.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.freestyle.domainobject.User;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {

	private static final Logger log=LoggerFactory.getLogger(UserDAOImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	User user;
	public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		}
	
	@Transactional
	public boolean saveUser(User user) {
		log.debug("Entering saveOrUpdate method");
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("Exiting saveOrUpdate method");
		return false;
	}
	
	@Transactional
	public boolean updateUser(User user) {
		log.debug("Entering updateUser method");
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("Exiting updateUser method");
		return false;
	}

	@Transactional
	public void delete(int id) {
		log.debug("Entering delete method");
		try {
			User user=new User();
			user.setUser_id(id);
			sessionFactory.getCurrentSession().delete(user);
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("Exiting delete method");
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public User getById(int id) {
		log.debug("Entering getById method");
		try {
			List<User> list=sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("user_id", id)).list();
			if(list!=null && !list.isEmpty()){
				return list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("Exiting getById method");
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> listUser() {
		log.debug("Entering listUser method");
		List<User> list=sessionFactory.getCurrentSession().createCriteria(User.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("Exiting listUser method");
		return list;
	}

	@Transactional
	public User authenticate(String name, String password) {
		String hql="from User where user_name="+name+"and password="+password;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		User user=(User) query.uniqueResult();
		return user;
		
	}
	
	/*@SuppressWarnings("unchecked")
	@Transactional
	public User getByName(String name) {
		log.debug("Entering getByName method");
		try {
			String hql="from User where user_name="+"'"+name+"'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<User> list=(List<User>)query.list();
			if(list!=null && !list.isEmpty()){
				return list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("Exiting getByName method");
		return null;
	}*/

	

}
