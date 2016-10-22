package com.collaboration.dao;

import java.util.*;
import com.collaboration.model.*;
	
public interface ForumDaoInterface
{
	public void createNewForum(Forum f);
	public List<Forum> getForumList(String UserName);
	public void delete(int fid);
	public List<Forum> getForum();
}
