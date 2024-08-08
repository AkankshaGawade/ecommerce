package com.wu.ecommerce.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.utils.DBUtils;

public class ProductRepositoryImpl implements ProductRepository {

	private ProductRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	//private Set<Product> produts = new HashSet<Product>();
//private TreeSet<Product> products=new TreeSet<Product>(new Comparator<Product>() {
//
//	@Override
//	public int compare(Product o1, Product o2) {
//		// TODO Auto-generated method stub
//		return o1.getProductName().compareTo(o2.getProductName());
//	}
//});
	private List<Product> products=new ArrayList<Product>();
//	private Product[] products = new Product[10];

	private static ProductRepository productRepository;
	private static int counter = -1;

	public static ProductRepository getInstance() {
		if (productRepository == null) {
			// create the object
			productRepository = 
					new ProductRepositoryImpl();
		}
		return productRepository;
	}

	public Product addProduct(Product product) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String insertStatement="insert into product(productId,productName,price,categoryName) "
				+ "values(?,?,?,?)";
		Connection connection=DBUtils.getInstance().getConnection();
		//preparedStatement:
		PreparedStatement preparedStatement=connection.prepareStatement(insertStatement);
		preparedStatement.setString(1, product.getProductId());
		preparedStatement.setString(2, product.getProductName());
		preparedStatement.setFloat(3,product.getPrice());
		preparedStatement.setString(4, product.getCategoryName());
		
		int result=preparedStatement.executeUpdate();
		
		if(result>0)
			return product;
		else
			return null;
	}

	public List<Product> getEmployeeByProductId(String id) throws IdNotFoundException, ClassNotFoundException, SQLException, InvalidIdException, InvalidPriceException, DataNotFoundException {
		// TODO Auto-generated method stub
String query="select *from product where productId=productId";
		
		Connection connection=DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		ResultSet resultSet=preparedStatement.executeQuery();
		List<Product> products=new ArrayList<Product>();
		while(resultSet.next()) {
			Product product=new Product();
			product.setProductId(resultSet.getString("productId"));
			product.setProductName(resultSet.getString("productName"));
			product.setPrice(resultSet.getFloat("price"));
			product.setCategoryName(resultSet.getString("categoryName"));
			products.add(product);
		}
		
		List<Product> temp=products.stream().filter(e->e.getProductId().equals(id)).collect(Collectors.toList());
		
		return (List<Product>) Optional.ofNullable(temp)
				.filter(l->!l.isEmpty())
				.orElseThrow(()->new DataNotFoundException("Data not available"));
	}

	public List<Product> getProducts() throws DataNotFoundException, ClassNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub

		String query="select *from product";
		Connection connection=DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		ResultSet resultSet=preparedStatement.executeQuery();
		
		List<Product> products=new ArrayList<Product>();
		while(resultSet.next()) {
			Product product=new Product();
			product.setProductId(resultSet.getString("productId"));
			product.setProductName(resultSet.getString("productName"));
			product.setPrice(resultSet.getFloat("price"));
			product.setCategoryName(resultSet.getString("categoryName"));
			products.add(product);
		}
		return Optional.ofNullable(products)
				.filter(l->!l.isEmpty())
				.orElseThrow(()->new DataNotFoundException("Data not found"));
		//return Optional.ofNullable(products);
	}

	public List<Product> getAllProductsByCategory(String cat) throws DataNotFoundException, ClassNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		String query="select *from product where categoryName=categoryName";
		
		Connection connection=DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		ResultSet resultSet=preparedStatement.executeQuery();
		List<Product> products=new ArrayList<Product>();
		while(resultSet.next()) {
			Product product=new Product();
			product.setProductId(resultSet.getString("productId"));
			product.setProductName(resultSet.getString("productName"));
			product.setPrice(resultSet.getFloat("price"));
			product.setCategoryName(resultSet.getString("categoryName"));
			products.add(product);
		}
		
		List<Product> temp=products.stream().filter(e->e.getCategoryName().equals(cat)).collect(Collectors.toList());
		
		return (List<Product>) Optional.ofNullable(temp)
				.filter(l->!l.isEmpty())
				.orElseThrow(()->new DataNotFoundException("Data not available"));
	}

	public String removeProductByProductId(String id) throws IdNotFoundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
//		//Product product=this.getEmployeeByProductId(id);
//	.id.	boolean result=products.remove(product);
//		if(result)
//			return "Success";
//		else 
			return null;

		
	}

	public Product updateproductByProductId(String id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
