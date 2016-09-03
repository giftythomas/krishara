package com.freestyle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"user_name"}))
@Component
public class User {

	@Id
	@GeneratedValue
	private int user_id;
	@NotEmpty(message = "Username should not be empty")
	
	private String user_name;
	@NotEmpty(message = "Password should not be empty")
	@Size(min=8, max=20,message="Password must have minimum eight characters")
	private String password;
	@NotEmpty(message = "Emailid should not be empty")
	@Email(message="Given emailId is not valid format")
	private String emailid;
	@NotEmpty(message = "Address should not be empty")
	private String user_address;
	
	@OneToOne
	@JoinColumn(name="cart_id")
	@JsonIgnore
	private Cart cart;
	
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	

}
