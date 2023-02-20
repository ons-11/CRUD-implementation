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
	UserRepository userRepository;
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User retrieveUserById(long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User user, long id) {
		User existingUser = userRepository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("user not found: " + id));
		existingUser.setFirstname(user.getFirstname());
		existingUser.setLastname(user.getLastname());
		userRepository.save(existingUser);
		return existingUser;
	}
}
