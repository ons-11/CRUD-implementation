package com.stage.users.Controllers;

import java.util.ArrayList;
import java.util.List;

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
	UserIservice userservice;
	
	
	@PostMapping("/adduser")
	public ResponseEntity AddUser(@RequestBody User user) {
		User usersave = null ; 
	try {
		usersave = userservice.addUser(user);;
	} catch (Exception ex) {
		ex.printStackTrace();
        return  ResponseEntity.badRequest().body(ex.getMessage());
	}
		return ResponseEntity.status(HttpStatus.CREATED).body(usersave);
	}


		@GetMapping("/getallusers")
		public ResponseEntity getallusers(){
			List<User> users = new ArrayList<>();
			try {
				users = userservice.retrieveallusers();;
				
			}  catch (Exception ex) {
	            ex.printStackTrace();
	            return ResponseEntity.badRequest().body(ex.getMessage());
	        }
	        return ResponseEntity.status(HttpStatus.OK).body(users);
	    }

		
		@GetMapping("/getuser/{id}")
		
		public ResponseEntity  getuser(@PathVariable("id") long id) {
			User user = null ;
			try {
				user = userservice.retrieveUserbyid(id);
				}
				catch (Exception ex) {
		            ex.printStackTrace();
		            return ResponseEntity.badRequest().body(ex.getMessage());
		        }
		        return ResponseEntity.status(HttpStatus.OK).body(user);
		    }
	
	
		@PutMapping("/updateuser/{id}")
		
		public User updateuser(@RequestBody User user , @PathVariable("id") long id) {
			return userservice.updateUser(user, id);
		}
		
		@DeleteMapping("/delete/{id}")
		public void deleteUser(@PathVariable("id") long id) {
			
			userservice.deleteUser(id);
		}
}
