package com.example.Package1;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class User {

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
