package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.Optional;

import com.wu.ecommerce.dto.User;

public interface UserService {
	   public Optional<User> getUserById(String id);
	   
	   public User addUser(User user) throws ClassNotFoundException, SQLException;
}
