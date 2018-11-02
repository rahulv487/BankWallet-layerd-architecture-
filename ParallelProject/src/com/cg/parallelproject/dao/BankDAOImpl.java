package com.cg.parallelproject.dao;

import java.util.Map;
import com.cg.parallelproject.dto.Customer;
import com.cg.parallelproject.exception.BankException;

public class BankDAOImpl implements BankDAO {
	
	Map<String, Customer> map;

	
	public BankDAOImpl() {
		map = DataContainer.createCollection();
		map.put("9761064337",new Customer("Rahul", "9761064337", 2600));
		map.put("7017838381",new Customer("Rashi", "7017838381", 3600));
		map.put("9632587410",new Customer("Keerti", "9632587410", 4600));

		

	}
	
	@Override
	public Customer createAccount(Customer c) {
		// TODO Auto-generated method stub
		if(map.get(c.getMobileNumber()) == null){
			map.put(c.getMobileNumber(), c);
			return c;
		}
		else
			return  null;
	}

	@Override
	public double showBalance(String mobileno) {
		// TODO Auto-generated method stub
		Customer cShow = map.get(mobileno);
		double bal = cShow.getAmount();
		return bal;
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, double amount) throws BankException {
		// TODO Auto-generated method stub
		Customer cfunds = map.get(sourceMobileNo);
		Customer cfundr = map.get(targetMobileNo);
		if((cfunds.getAmount()-amount) >= 0){
			cfundr.setAmount(cfundr.getAmount()+amount);
			map.put(targetMobileNo, cfundr);
			cfunds.setAmount(cfunds.getAmount()-amount);
			map.put(sourceMobileNo, cfunds);
			

			
		}
		else
			throw new BankException("Insufficient balance...");
		

		return cfunds;
	}

	@Override
	public Customer depositAmount(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		Customer cDep = map.get(mobileNo);
		cDep.setAmount(cDep.getAmount()+amount);
		map.put(mobileNo, cDep);
		
		return cDep;
	}

	@Override
	public Customer withdrawAmount(String mobileNo, double amount) throws BankException {
		// TODO Auto-generated method stub
		Customer cDep = map.get(mobileNo);
		if((cDep.getAmount()-amount) >= 0){
			cDep.setAmount(cDep.getAmount()-amount);
			map.put(mobileNo, cDep);
		}
		else
			throw new BankException("Unable to withdraw money...\n"
					+ "Make sure that the balance should be greater than or equal to zero");
		return cDep;
	}

}
