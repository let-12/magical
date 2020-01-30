package com.lti.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
	
	private List<User> users;
	
	
	public UserService()
	{
		users = new ArrayList<User>();
		users.add(new User("maj","123",true));
		users.add(new User("nik","124",false));
		users.add(new User("maj","123",true));
	}

	public boolean isValidUser(String username, String password){
		for(User user : users)
			if( user.getUsername().equals(username)) 
				if( user.getPassword().equals(password)) 
			if(user.isAllowed())
	
			return true;
		
			return false;
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter username : ");
		String username = sc.next();
		System.out.print("Enter password : ");
		String password =sc.next();
		UserService u = new UserService();
		boolean isValid = u.isValidUser(username,password);
		if(isValid)
			System.out.println("Passed");
		
		else
			System.out.println("Failed");
	}
		
	}

