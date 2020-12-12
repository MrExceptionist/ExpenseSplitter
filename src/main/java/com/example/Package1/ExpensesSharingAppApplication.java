package com.example.Package1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ExpensesSharingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensesSharingAppApplication.class, args);
	}
	
	@Component
	public class CommandLineAppStartupRunner implements CommandLineRunner {
	    @Autowired
	    private Info infoObject;

	    @Override
	    public void run(String...args) throws Exception {
	       infoObject.information();

	    }
	}

}
