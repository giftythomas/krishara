package com.freestyle.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freestyle.dao.UserDAO;
import com.freestyle.domainobject.User;

@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private User user;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		log.debug("<---Entering listAllUsers method--->");
		List<User> users = userDAO.listUser();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") String id) {
		log.debug("<---Entering getUser method--->");
		User user = userDAO.getById(id);
		if (user == null) {
			user=new User();
			user.setErrorMessage("User does not exist with the given Id");
		}
		log.debug("<-- Got the user with Id+ -->"+user.getUser_id());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		log.debug("<---Entering saveUser method--->");
		if (userDAO.getById(user.getUser_id()) == null) {
			userDAO.saveUser(user);
			log.debug("<-- User is about to create --->");
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		log.debug("<---User already exists with user_id" + user.getUser_id());
		return new ResponseEntity<User>(user, HttpStatus.CONFLICT);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
		log.debug("<---Entering updateUser method--->");
		if(userDAO.getById(id)==null){
			log.debug("<-- User about to update -->");
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		userDAO.updateUser(user);
		log.debug("<---User updated successfully--->");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
		log.debug("<---Entering deleteUser method--->");
		User user = userDAO.getById(id);
		if (user == null) {
			log.debug("<---User doesn't exist with id--->");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userDAO.delete(id);
		log.debug("<---User deleted successfully--->");
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<User> authenticate(@RequestBody User user){
		return null;
		
		
	}
}
