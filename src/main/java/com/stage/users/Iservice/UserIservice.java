package com.stage.users.Iservice;

import java.util.List;

import com.stage.users.Model.User;

public interface UserIservice {
	
	public User addUser (User user);
	
	public List <User> retrieveallusers();
	
	public User updateUser(User user , long id);
	
	public User retrieveUserbyid(long id);
	
	public void deleteUser(long id);

}
