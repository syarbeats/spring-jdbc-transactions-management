package com.learning.spring.spring_transaction_management;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.learning.spring.spring_transaction_management.dao.AddEmployeeTransManagementDao;
import com.learning.spring.spring_transaction_management.dao.EmployeeManagement;

public class AddEmployeeTransactionTemplate extends AddEmployeeTransManagementDao implements EmployeeManagement {

	private TransactionTemplate transactionTemplate;
	
	
	@Override
	public void hireNewEmployee(int id, String name, int salary) throws Exception {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				addEmployee(id, name, salary);
			}
			
		});
	}


	public TransactionTemplate getTransactionTemplate(){
		return transactionTemplate;
	}


	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

}
