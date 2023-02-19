package com.stage.users.Iservice;

import java.util.List;

import com.stage.users.Model.User;

public interface UserIservice {
	
	public User addUser (User user);
	public List <User> retrieveAllUsers();
	public User updateUser(User user , long id);
	public User retrieveUserById(long id);
	public void deleteUser(long id);

}
