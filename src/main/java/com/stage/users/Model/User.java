package com.stage.users.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="users")
public class User {
	@Id
	private long id;
	private String firstname;
	private String lastname;
	
	
}
