package com.learning.spring.spring_transaction_management;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.spring.spring_transaction_management.dao.EmployeeManagement;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx =  new ClassPathXmlApplicationContext("META-INF/application-context.xml");
    	
    	/*
    	 * USING DATASOURCE TRANSACTION MANAGEMENT
    	 * **/
    	//EmployeeManagement empManagement = (EmployeeManagement) ctx.getBean("employeeTranManager");
    	
    	/*
    	 * USING DATASOURCE TRANSACTION MANAGEMENT WITH TRANSACTION TEMPLATE
    	 * **/
    	EmployeeManagement empManagement = (EmployeeManagement) ctx.getBean("employeeTranTemplate");
    	
    	
    	try {
    		empManagement.hireNewEmployee(407, "Brian May", 55000);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    	
    }
}
