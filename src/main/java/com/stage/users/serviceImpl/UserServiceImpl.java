package com.stage.users.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.stage.users.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.stage.users.Iservice.UserIservice;
import com.stage.users.Model.User;
import com.stage.users.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserIservice {

	@Autowired
	UserRepository userRepo;

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User retrieveUserById(long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public List<User> retrieveAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public void deleteUser(long id) {
		userRepo.deleteById(id);
	}

	@Override
	public User updateUser(User user, long id) {
		Optional<User> existingUser = userRepo.findById(id);
		if (existingUser.isPresent()) {
			User updateUser = existingUser.get();
			updateUser.setFirstname(user.getFirstname());
			updateUser.setLastname(user.getLastname());
			userRepo.save(updateUser);
			return updateUser;
		} else {
	throw new ResourceNotFoundException("user not found" + id);
		}
	}
}
