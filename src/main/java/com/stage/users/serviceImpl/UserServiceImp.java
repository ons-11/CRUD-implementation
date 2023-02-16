package com.stage.users.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.users.Iservice.UserIservice;
import com.stage.users.Model.User;
import com.stage.users.Repository.UserRepository;

@Service
public class UserServiceImp implements UserIservice{

	@Autowired
	UserRepository userrepo;

	@Override
	public User addUser(User user) {
	
		return userrepo.save(user);
	}



	@Override
	public User retrieveUserbyid(long id) {
		
		return userrepo.findById(id).get();
	}



	@Override
	public List<User> retrieveallusers() {
		return userrepo.findAll();
	}


	@Override
	public void deleteUser(long id) {
		userrepo.deleteById(id);
		
	}



	@Override
	public User updateUser(User user, long id) {
		User u = userrepo.findById(id).get();
		u.setFirstname(user.getFirstname());
		u.setLastname(user.getLastname());
		return userrepo.save(u);
	}

	
	
}
