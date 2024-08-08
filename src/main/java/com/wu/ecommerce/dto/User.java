package com.wu.ecommerce.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter

public class User {
    private String userId;
    private String FirstName;
    private String Lastname;
    private double contactNumber;
    public User(String userId,String FirstName,String LastName,double contactNumber) {
		// TODO Auto-generated constructor stub
    	super();
    	this.userId=userId;
    	this.FirstName=FirstName;
    	this.Lastname=LastName;
    	this.contactNumber=contactNumber;
	}
}
