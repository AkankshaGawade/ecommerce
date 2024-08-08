package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;

public interface ProductService {
	public Product addProduct (Product product) throws SQLException, ClassNotFoundException;
	   //when you are not sure whether you will get some value or not at that time use optional return type.
	   public List<Product> getEmployeeByProductId(String id) throws IdNotFoundException, ClassNotFoundException, SQLException, InvalidIdException, InvalidPriceException, DataNotFoundException;
	   
	   public List<Product> getProducts() throws DataNotFoundException, ClassNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	   public List<Product> getAllProductsByCategory(String cat) throws DataNotFoundException, ClassNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	   
	   public String removeProductByProductId(String id) throws IdNotFoundException, ClassNotFoundException, SQLException;
	   public Product updateproductByProductId(String id,Product product);
	   
	   
}
