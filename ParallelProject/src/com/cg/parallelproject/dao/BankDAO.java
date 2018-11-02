package com.cg.parallelproject.dao;

import com.cg.parallelproject.dto.Customer;
import com.cg.parallelproject.exception.BankException;

public interface BankDAO {
	
	public Customer createAccount(Customer c);
	public double showBalance (String mobileno);
	public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, double amount) throws BankException;
	public Customer depositAmount (String mobileNo, double amount );
	public Customer withdrawAmount(String mobileNo, double amount) throws BankException;

}
