package com.wu.ecommerce.repo;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.utils.DBUtils;

public class UserRepositoryImpl implements UserRepository {

	private static UserRepository userRepository;
	private List<User> users=new ArrayList<User>();
	public static UserRepository getInstance() {
		if (userRepository == null) {
			// create the object
			userRepository = 
					new UserRepositoryImpl();
		}
		return userRepository;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User user) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String insertStatement="insert into user_table(userId,FirstName,LastName,contactNumber) "
				+ "values(?,?,?,?)";
		Connection connection=DBUtils.getInstance().getConnection();
		//preparedStatement:
		PreparedStatement preparedStatement=connection.prepareStatement(insertStatement);
		preparedStatement.setString(1,user.getUserId());
		preparedStatement.setString(2, user.getFirstName());
		preparedStatement.setString(3,user.getLastname());
		preparedStatement.setDouble(4,user.getContactNumber());
		
		int result=preparedStatement.executeUpdate();
		
		if(result>0)
			return user;
		else
			return null;
	}

}
