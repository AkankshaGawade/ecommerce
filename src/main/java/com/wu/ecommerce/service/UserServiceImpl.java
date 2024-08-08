package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.Optional;

import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.repo.ProductRepository;
import com.wu.ecommerce.repo.ProductRepositoryImpl;
import com.wu.ecommerce.repo.UserRepository;
import com.wu.ecommerce.repo.UserRepositoryImpl;

public class UserServiceImpl implements UserService {
	
	private UserRepository useRepository=UserRepositoryImpl.getInstance();
	private static UserRepository userRepository;
	public static UserRepository getInstance() {
		if (userRepository == null) {
			// create the object
			userRepository = 
					new UserRepositoryImpl();
		}
		return userRepository;
	}
	
	

	public Optional<User> getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User addUser(User user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.addUser(user);
	}

	
}
