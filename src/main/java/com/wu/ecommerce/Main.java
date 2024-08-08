package com.wu.ecommerce;

import java.sql.SQLException;
import java.util.Iterator;

import java.util.Optional;
import java.util.Scanner;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.repo.UserRepository;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;
import com.wu.ecommerce.service.UserService;
import com.wu.ecommerce.service.UserServiceImpl;

import lombok.EqualsAndHashCode;

public class Main {

	public static void main(String[] args) throws InvalidIdException, InvalidPriceException, DataNotFoundException, IdNotFoundException, SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		ProductService productService=ProductServiceImpl.getInstance();
		
		UserRepository userService=UserServiceImpl.getInstance();
		User user1=new User("uid1","Akanksha","Gawade",8381);
	
		
//		Product product=new Product("abcd", "ball", 50,"cat2");
//		Product product1=new Product("abcd2", "ball", 50,"cat1");
		Product product2=new Product("abcd5", "ball", 50,"cat1");
//		Product product3=new Product("abcd1", "ball", 50,"cat3");
//		Product product4=new Product("abcd3", "ball", 50,"cat1");
////		product.compareTo(product);
		int choice=0;
		while (true) {
			System.out.print("Enter your choice:");
			choice=sc.nextInt();
			switch (choice) {
			case 1:
				productService.addProduct(product2);
				break;

			case 2:
				System.out.println(productService.getProducts());
				break;
			
			case 3:
				System.out.println(productService.getAllProductsByCategory("cat2"));
				break;
				
			case 4:
				System.out.println(productService.getEmployeeByProductId("abcd1"));
				break;
			
				
			}
		}
	
	}

}
