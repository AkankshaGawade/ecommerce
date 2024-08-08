package com.wu.ecommerce.repo;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;

public interface UserRepository {
	
	   //when you are not sure whether you will get some value or not at that time use optional return type.
	   public List<User> getUserById(String id) throws ClassNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	   
	  public User addUser(User user) throws SQLException, ClassNotFoundException;
}
