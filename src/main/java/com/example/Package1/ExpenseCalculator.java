package com.example.Package1;



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
		String payee = sc.next();
		objExpenseDetails.setPaid_by(payee);
		
		System.out.println("Split_by : ");
		System.out.println("Type E for Equal");
		System.out.println("Type U for Unequal");
		System.out.println("Type P for Percent");
		String split_by = sc.next();
		objExpenseDetails.setSplit_by(split_by);
		
		switch(split_by) {
		case "E":
			calculateShares(myMap);
			break;
			
		case "P":
			calculateSharesByPercent(myMap);
			break;
			
		case "U":
			calculateSharesByUnequal(myMap);
		}		
		
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
		
		
		for(Map.Entry<String,Double> m : myMap.entrySet()) {
			if(m.getValue()<0)
			System.out.println(m.getKey()+" gets back "+Math.abs(m.getValue()));
			else
			System.out.println(m.getKey()+" owes "+Math.abs(m.getValue()));
			
	}
	
		
		
	}
	
	public void calculateSharesByPercent(Map<String,Double> myMap) {
		myMap.replace(objExpenseDetails.getPaid_by(), myMap.get(objExpenseDetails.getPaid_by())-objExpenseDetails.getAmount());
		Scanner sc = new Scanner(System.in);
		for(Map.Entry<String,Double> m : myMap.entrySet()) {
			System.out.println("Enter % of amount owed by "+m.getKey()+" :");
			myMap.replace(m.getKey(), m.getValue()+sc.nextDouble()*objExpenseDetails.getAmount()/100);
		}
		
	
		
		for(Map.Entry<String,Double> m : myMap.entrySet()) {
			if(m.getValue()<0)
			System.out.println(m.getKey()+" gets back "+Math.abs(m.getValue()));
			else
			System.out.println(m.getKey()+" owes "+Math.abs(m.getValue()));
			
	}

		
	}
	
	
	public void calculateSharesByUnequal(Map<String,Double> myMap) {
		myMap.replace(objExpenseDetails.getPaid_by(), myMap.get(objExpenseDetails.getPaid_by())-objExpenseDetails.getAmount());
		Scanner sc = new Scanner(System.in);
		for(Map.Entry<String,Double> m : myMap.entrySet()) {
			System.out.println("Enter value of amount owed by "+m.getKey()+" :");
			myMap.replace(m.getKey(), m.getValue()+sc.nextDouble());
		}
		
	
		
		for(Map.Entry<String,Double> m : myMap.entrySet()) {
			if(m.getValue()<0)
			System.out.println(m.getKey()+" gets back "+Math.abs(m.getValue()));
			else
			System.out.println(m.getKey()+" owes "+Math.abs(m.getValue()));
			
	}
		
	}
	
}
