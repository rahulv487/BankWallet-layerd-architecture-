package com.cg.parallelproject.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.parallelproject.dao.BankDAO;
import com.cg.parallelproject.dao.BankDAOImpl;
import com.cg.parallelproject.dto.Customer;
import com.cg.parallelproject.exception.BankException;
import com.cg.parallelproject.exception.InvalidAmount;
import com.cg.parallelproject.exception.InvalidPhoneNumber;

public class BankServiceImpl implements BankService{
	
	BankDAO dao;
	
	public BankServiceImpl() {
		dao = new BankDAOImpl();	
	}
	
	/*@Override
	public boolean validateAll(Customer c){
		
		boolean b = false;

		if(validateUserName(c.getCustomerName()) == true && validatePhoneNumber(c.getMobileNumber()) == true && validateAmount(c.getAmount()) == true)
			b = true;
		return b;
	}*/
	
	@Override
	public boolean validateUserName(String name){
		
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{2,15}");
		Matcher mat = p.matcher(name);
		boolean b = mat.matches();
		
		return b;
	}
	
	@Override
	public boolean validatePhoneNumber(String mobileNo){
		
		Pattern pat = Pattern.compile("[6-9]{1}[0-9]{9}");
		Matcher mat = pat.matcher(mobileNo);
		
		return mat.matches();
	}
	
	@Override
	public boolean validateAmount(double amt){
		
		Pattern pat = Pattern.compile("[1-9]{1}[0-9.]{0,9}");
		Matcher mat = pat.matcher(String.valueOf(amt));
		
		return mat.matches();
	}
	
	@Override
	public boolean validateTargetMobNo(String targetMobNo){
		
		Pattern pat = Pattern.compile("[6-9]{1}[0-9]{9}");
		Matcher mat = pat.matcher(targetMobNo);
		
		return mat.matches();
	}

	@Override
	public Customer createAccount(Customer c) {
		// TODO Auto-generated method stub
		return dao.createAccount(c);
	}

	@Override
	public double showBalance(String mobileno) throws InvalidPhoneNumber {
		// TODO Auto-generated method stub
		double bal = dao.showBalance(mobileno);
		return bal;
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, double amount) throws BankException {
		// TODO Auto-generated method stub
		Customer c = dao.fundTransfer(sourceMobileNo, targetMobileNo, amount);
		return c;
	}

	@Override
	public Customer depositAmount(String mobileNo, double amount) throws InvalidPhoneNumber, InvalidAmount {
		// TODO Auto-generated method stub
		Customer c = dao.depositAmount(mobileNo, amount);
		return c;
	}

	@Override
	public Customer withdrawAmount(String mobileNo, double amount) throws BankException {
		// TODO Auto-generated method stub
		Customer c = dao.withdrawAmount(mobileNo, amount);
		return c;
	}

}
