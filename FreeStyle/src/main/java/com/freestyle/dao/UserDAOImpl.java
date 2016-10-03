package com.freestyle.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.freestyle.model.Cart;
import com.freestyle.model.RoleAuthority;
import com.freestyle.model.User;

@Component
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public User initFlow(){
		return new User();
	}

	public String addUser(User user) {
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
		return "added";
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
		User user=(User) query.uniqueResult();
		transaction.commit();
		return user;
	}

	public void deleteUser(int id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		User user=session.get(User.class, new Integer(id));
		session.delete(user);
		transaction.commit();
	}

	public String validateUser(User user,MessageContext messageContext) {
		String status="success";
		if(user.getUser_name().isEmpty()){
			messageContext.addMessage(new MessageBuilder()
					.error().source("user_name").defaultText("Name cannot be empty").build());
				status="failure";
			}
		if(user.getPassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder()
					.error().source("password").defaultText("Password cannot be empty").build());
			status="failure";
		}
		if(user.getEmailid().isEmpty()){
			messageContext.addMessage(new MessageBuilder()
					.error().source("emailid").defaultText("EmailId cannot be empty").build());
			status="failure";
		}
		if(user.getUser_address().isEmpty()){
			messageContext.addMessage(new MessageBuilder()
					.error().source("user_address").defaultText("Address cannot be empty").build());
			status="failure";
		}
		return status;
	}
}
