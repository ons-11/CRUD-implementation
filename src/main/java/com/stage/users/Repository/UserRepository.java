package com.stage.users.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stage.users.Model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long>{

}
