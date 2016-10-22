package com.freestyle.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.freestyle.domainobject.Blog;
import com.freestyle.domainobject.User;
@Component("blogDAO")
public class BlogDAOImpl implements BlogDAO{

	private static final Logger log=LoggerFactory.getLogger(BlogDAOImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	Blog blog;
	@Autowired
	User user;
	public BlogDAOImpl(SessionFactory sessionFactory){
		log.debug("<-- Entering sessionFactory -->");
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		   }
		log.debug("<-- Exiting sessionFactory -->");
		}
	@Transactional
	public boolean save(Blog blog) {
		log.debug("<-- Enetring save method -->");
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- Exiting save method -->");
		return false;
	}

	@Transactional
	public boolean update(Blog blog) {
		log.debug("<-- Entering update method -->");
		try {
			sessionFactory.getCurrentSession().update(blog);
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- Exiting update method -->");
		return false;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Blog> listBlog() {
		log.debug("<-- Entering listBlog method -->");
		List<Blog> list=sessionFactory.getCurrentSession().createCriteria(Blog.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		log.debug("<-- Exiting listBlog method -->");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Blog getBlog(int id) {
		log.debug("<-- Entering getBlog method -->");
		try {
			List<Blog> list=sessionFactory.getCurrentSession().createCriteria(Blog.class)
					.add(Restrictions.eq("id", id)).list();
			if(list!=null && !list.isEmpty()){
				return list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("<-- Exiting getBlog method -->");
		return null;
	}

}
