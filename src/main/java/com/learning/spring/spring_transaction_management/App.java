package com.learning.spring.spring_transaction_management;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.spring.spring_transaction_management.dao.EmployeeManagement;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx =  new ClassPathXmlApplicationContext("META-INF/application-context.xml");
    	EmployeeManagement empManagement = (EmployeeManagement) ctx.getBean("employeeTranManager");
    	
    	try {
    		empManagement.hireNewEmployee(405, "Rod Steward", 55000);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    }
}
