package com.example.Package1;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpenseCalculator {
	
	@Autowired
	private Info infoObject;
	
	@Autowired
	private ExpenseDetails objExpenseDetails;
	
	public void storeDetails(List<User> users) {
		
		Map<String,Double> myMap = new HashMap();
		
		for(int i=0;i<users.size();i++) {
			myMap.put(users.get(i).getUserName(),0.0);
		}
		System.out.println(myMap);
		
		getExpenses(users,myMap);
		
	
	}
	
	public void getExpenses(List<User> users,Map<String,Double> myMap) {
		System.out.println("Please enter the expenses");
		
		Scanner sc = new Scanner(System.in);
		
		//ExpenseDetails objExpenseDetails = new ExpenseDetails();
		
		System.out.println("Expense name :");
		objExpenseDetails.setExpenseName(sc.next());
		
		System.out.println("Amount :");
		objExpenseDetails.setAmount(sc.nextDouble());
		
		System.out.println("Paid_by :");
		objExpenseDetails.setPaid_by(sc.next());
		
		System.out.println("Split_by :");
		objExpenseDetails.setSplit_by(sc.next());
		
		calculateShares(myMap);
		
		System.out.println("Do you want to add more expenses ? (Y/N)");
		String response = sc.next();
		
		if("Y".equals(response))
			getExpenses(users,myMap);
		
		
	}
	

	
	public void calculateShares(Map<String,Double> myMap) {
		 myMap.replace(objExpenseDetails.getPaid_by(), myMap.get(objExpenseDetails.getPaid_by())-objExpenseDetails.getAmount());
		 double newValue;
		for(Map.Entry<String,Double> m : myMap.entrySet()) {
			newValue=0;
			newValue+=m.getValue()+objExpenseDetails.getAmount()/myMap.size();
			myMap.replace(m.getKey(),(double)Math.round(newValue*100)/100);
		}
		System.out.println(myMap);
		
		for(Map.Entry<String,Double> m : myMap.entrySet()) {
			if(m.getValue()<0)
			System.out.println(m.getKey()+" gets back "+Math.abs(m.getValue()));
			else
			System.out.println(m.getKey()+" owes "+Math.abs(m.getValue()));
			
	}
		
		
	}
	
	
}
