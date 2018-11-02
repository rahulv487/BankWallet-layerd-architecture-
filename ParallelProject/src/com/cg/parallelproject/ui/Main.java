package com.cg.parallelproject.ui;

import java.util.Scanner;

import com.cg.parallelproject.dto.Customer;
import com.cg.parallelproject.exception.BankException;
import com.cg.parallelproject.exception.InvalidAmount;
import com.cg.parallelproject.exception.InvalidPhoneNumber;
import com.cg.parallelproject.exception.NameException;
import com.cg.parallelproject.service.BankService;
import com.cg.parallelproject.service.BankServiceImpl;

public class Main {
	
	public static void main(String[] args) throws BankException, NameException, InvalidPhoneNumber, InvalidAmount {
		
		Scanner sc = new Scanner(System.in);
		BankService service = new BankServiceImpl();
		
		int option;
		do{
			
			System.out.println("1. Create Account...");
			System.out.println("2. Show Balance...");
			System.out.println("3. Fund Transfer...");
			System.out.println("4. Deposit...");
			System.out.println("5. Withdraw...");
			System.out.println("6. Print Transactions...");
			System.out.println("7. Exit...");
			option = sc.nextInt();
			
			switch (option) {
			case 1:

				//service = new BankServiceImpl();
				
				System.out.println("Enter Customer Name: ");
				String name = sc.next();
				if(!service.validateUserName(name)){
					throw new NameException();
				}
				System.out.println("Enter Mobile Number: ");
				String mobNo = sc.next();
				if(!service.validatePhoneNumber(mobNo)){
					throw new InvalidPhoneNumber();
				}
				System.out.println("Enter Initial Amount: ");
				double B = sc.nextDouble();
				if(!service.validateAmount(B)){
					throw new InvalidAmount();
				}
				
				Customer c = new Customer(name, mobNo, B);
				Customer c1 = service.createAccount(c);
				/*if(service.validateAll(c))
					c1 = service.createAccount(c);
				else
					throw new BankException("Invalid details...");*/
				if(c1 == null)
					System.out.println("Number already exist in Bank");
				else{
					System.out.println(c1);
					System.out.println("Successfully created new account for "+c1.getCustomerName()+" with "
										+ "Mobile Number "+c1.getMobileNumber());
				}
				break;
			
			case 2:
				
				System.out.println("Enter an existing mobile number: ");
				String mobNoShow = sc.next();
				if(!service.validatePhoneNumber(mobNoShow)){
					throw new InvalidPhoneNumber();
				}
				
				double bal = service.showBalance(mobNoShow);
				System.out.println("Available balance for the mobile number "+mobNoShow+" is " +bal);
				
				break;
			
			case 3:
				
				System.out.println("Enter your mobile number: ");
				String sourceMobileNo = sc.next();
				if(!service.validatePhoneNumber(sourceMobileNo)){
					throw new InvalidPhoneNumber();
				}
				System.out.println("Enter recipient's mobile number: ");
				String targetMobileNo = sc.next();
				if(!service.validatePhoneNumber(targetMobileNo)){
					throw new InvalidPhoneNumber();
				}
				System.out.println("Enter the amount that to be transfered: ");
				double amount = sc.nextDouble();
				if(!service.validateAmount(amount)){
					throw new InvalidAmount();
				}
				
				service = new BankServiceImpl();
				Customer funds =/* null;
				funds =*/ service.fundTransfer(sourceMobileNo, targetMobileNo, amount);
				System.out.println("Successfully transfered Rs."+amount+" to "+targetMobileNo+".\n"
						+ "Available balance is Rs. "+funds.getAmount());
				
				break;
			
			case 4:
				
				System.out.println("Enter your mobile number: ");
				String mobNoDep = sc.next();
				if(!service.validatePhoneNumber(mobNoDep)){
					throw new InvalidPhoneNumber();
				}
				System.out.println("Enter amount that to be deposited: ");
				double amtDep = sc.nextDouble();
				if(!service.validateAmount(amtDep)){
					throw new InvalidAmount();
				}
				
				//service = new BankServiceImpl();
				Customer cDep = service.depositAmount(mobNoDep, amtDep);
				
				System.out.println("Your current balance is Rs."+cDep.getAmount());

				
				break;
			
			case 5:
				
				System.out.println("Enter your mobile number: ");
				String mobNoWiDraw= sc.next();
				if(!service.validatePhoneNumber(mobNoWiDraw)){
					throw new InvalidPhoneNumber();
				}
				System.out.println("Enter amount that to be withdrawn: ");
				double amtWiDraw = sc.nextDouble();
				if(!service.validateAmount(amtWiDraw)){
					throw new InvalidAmount();
				}
				
				//service = new BankServiceImpl();
				Customer A= service.withdrawAmount(mobNoWiDraw, amtWiDraw);
				
				System.out.println("Your current balance is Rs. "+A.getAmount());
				
				break;
			case 6:
				System.out.println("-----Work in progress...-----");
				break;
			
			default:
			case 7:
				break;
			}
			
		}while(option != 7);
		
			
		sc.close();
		
	}

}
