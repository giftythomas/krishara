package com.collaboration.service;

import java.util.List;

import com.collaboration.model.Forum;
public interface ForumService 
{
public void createNewForum(Forum f);
public List<Forum> getForumList(String UserName);
public void delete(int fid);
public List<Forum> getForum();

}
