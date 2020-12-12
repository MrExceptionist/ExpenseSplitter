package com.example.Package1;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class ExpenseCalculator {
	
	@Autowired
	private Info infoObject;
	
	@Autowired
	private ExpenseDetails objExpenseDetails;
	
	public void getExpenses() {
		System.out.println("Please enter the expenses");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Expense name :");
		objExpenseDetails.setExpenseName(sc.next());
		
		System.out.println("Amount :");
		objExpenseDetails.setAmount(sc.nextDouble());
		
		System.out.println("Paid_by :");
		objExpenseDetails.setPaid_by(sc.next());
		
		System.out.println("Split_by :");
		objExpenseDetails.setSplit_by(sc.next());
		
	}

}
