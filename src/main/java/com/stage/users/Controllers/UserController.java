package com.stage.users.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.stage.users.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stage.users.Iservice.UserIservice;
import com.stage.users.Model.User;


@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	UserIservice userService;
	@Autowired
	UserRepository userRepo;

	@PostMapping("/add")
	public ResponseEntity AddUser(@RequestBody User user) {
		User saveUser = null ;
		try {
			saveUser = userService.addUser(user);;
			}
		catch (Exception ex) {
				ex.printStackTrace();
        		return  ResponseEntity.badRequest().body(ex.getMessage());
			}
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
			}

		@GetMapping
		public ResponseEntity getaAllUsers(){
			List<User> users = new ArrayList<>();
			try {
				users = userService.retrieveAllUsers();
				}
			catch (Exception ex) {
	            ex.printStackTrace();
	            return ResponseEntity.badRequest().body(ex.getMessage());
	        }
	        return ResponseEntity.status(HttpStatus.OK).body(users);
	    }

		@GetMapping("/get/{id}")
		
		public ResponseEntity  getUser(@PathVariable("id") long id) {
			User user = null ;
			try {
				user = userService.retrieveUserById(id);
				}
			catch (Exception ex) {
		            ex.printStackTrace();
		            return ResponseEntity.badRequest().body(ex.getMessage());
		        }
			return ResponseEntity.status(HttpStatus.OK).body(user);
		    }

		@PutMapping("/update/{id}")
		public ResponseEntity updateUser(@RequestBody User user , @PathVariable("id") long id) {
			User newUser = null;
			try {
				userService.updateUser(user, id);
			}
			catch (Exception ex) {
				ex.printStackTrace();
				return ResponseEntity.badRequest().body(ex.getMessage());
			}
			return ResponseEntity.status(HttpStatus.OK).body(newUser);
		}

		@DeleteMapping("/delete/{id}")
		public ResponseEntity deleteUser(@PathVariable("id") long id) {
			try {
				userService.deleteUser(id);
			}
			catch (Exception ex) {
				ex.printStackTrace();
				return ResponseEntity.badRequest().body(ex.getMessage());
			}

			return ResponseEntity.status(HttpStatus.OK).body("user deleted ");
		}

		}
