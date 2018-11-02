package com.cg.parallelproject.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cg.parallelproject.service.BankServiceImpl;

public class BankTest {
	
	@Test
	public void ValidateNameTrue(){
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(true, bs.validateUserName("Rahul"));
	}
	

	@Test
	public void ValidatePhonNumberTrue(){
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(true, bs.validatePhoneNumber("9632584170"));
	}
	
	@Test
	public void ValidateAmountTrue(){
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(true, bs.validateAmount(100));
	}
	
	@Test 
	public void ValidateNameV2(){
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(false, bs.validateUserName("Rahul487"));
		assertEquals(false, bs.validateUserName("Rahulv@487"));
		assertEquals(false, bs.validateUserName("9814533"));
		assertEquals(false, bs.validateUserName("rahulverma"));
	}
	@Test
	public void ValidatePhoneNumber(){
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(false, bs.validatePhoneNumber("963258417"));
		assertEquals(false, bs.validatePhoneNumber("4232584170"));
		assertEquals(false, bs.validatePhoneNumber("844170"));
		assertEquals(false, bs.validatePhoneNumber("testing"));
		assertEquals(false, bs.validatePhoneNumber("@#%"));
	}
	
	@Test 
	public void ValidateAmount(){
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(false, bs.validateAmount(0));
		assertEquals(false, bs.validateAmount(-400));
	}

}
