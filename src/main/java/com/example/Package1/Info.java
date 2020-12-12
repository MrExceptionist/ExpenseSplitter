package com.example.Package1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Info {
	
	@Autowired
	private User objUser;
	
	@Autowired
	private ExpenseCalculator objExpenseCalculator;

	
	public void information() {
	
	
	System.out.println("Please provide number of persons :");
	
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	
	System.out.println(n);
	
	List<User> users = new ArrayList<>();
	
	System.out.println("Please provide the names of the perons ");
	for(int i=1;i<=n;i++) {
		User objUser = new User();
		System.out.println("Person "+i);
		String sc = s.next();
		objUser.setUserName(sc);
		users.add(objUser);
	}
	System.out.println(users);
	
	objExpenseCalculator.getExpenses(users);
	}
}
