package com.collaboration.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaboration.dao.ForumDaoImpl;
import com.collaboration.model.Forum;

@Service
public class ForumServiceImpl implements ForumService
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	ForumDaoImpl forumdao;

	public ForumServiceImpl(){}
	
	public ForumServiceImpl(SessionFactory sf){
		this.sessionFactory=sf;
	}
	
	public void createNewForum(Forum f) {
		forumdao.createNewForum(f);
		
	}

	@Override
	public List<Forum> getForumList(String UserName) {
		
		return forumdao.getForumList(UserName);
		
	}

	@Override
	public void delete(int fid) {
		forumdao.delete(fid);
		
	}
	
	public List<Forum> getForum()
	{
		System.out.println("I am in forum service");
		return forumdao.getForum();
	}

}
