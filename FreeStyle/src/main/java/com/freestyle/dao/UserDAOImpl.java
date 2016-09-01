package com.freestyle.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freestyle.model.Cart;
import com.freestyle.model.User;
import com.freestyle.model.RoleAuthority;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void addUser(User user) {
		System.out.println("UserDAOImpl");
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		user.setEnabled(true);
		session.save(user);
		RoleAuthority userrole = new RoleAuthority();
		userrole.setAuthority("ROLE_USER");
		userrole.setId(user.getUser_id());
		session.save(userrole);
		Cart cart= new Cart();
		cart.setUser(user);
		user.setCart(cart);
		session.save(user);
		session.save(cart);
		transaction.commit();

	}

	@SuppressWarnings("unused")
	public List<User> viewUser() {
		Session session= sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User>list= session.createCriteria(User.class).list();
		return list;
	}

	
	public User getUserByName(String name) {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query= session.createQuery("from User where user_name=?");
		query.setString(0, name);
		transaction.commit();
		return (User) query.uniqueResult();
	}

	public void deleteUser(int id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		User user=session.get(User.class, new Integer(id));
		session.delete(user);
		transaction.commit();
	}

}
