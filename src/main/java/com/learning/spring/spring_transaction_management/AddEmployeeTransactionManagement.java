package com.learning.spring.spring_transaction_management;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.learning.spring.spring_transaction_management.dao.AddEmployeeTransManagementDao;
import com.learning.spring.spring_transaction_management.dao.EmployeeManagement;

public class AddEmployeeTransactionManagement extends AddEmployeeTransManagementDao implements EmployeeManagement {

	private PlatformTransactionManager transactionManager;
	
	@Override
	public void hireNewEmployee(int id, String name, int salary) throws Exception {
		TransactionDefinition transactionDef = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDef);
		try {
			addEmployee(id, name, salary);
			transactionManager.commit(transactionStatus);
		} catch (Exception e) {
			transactionManager.rollback(transactionStatus);
			throw e;
		}
		
	}

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
}
