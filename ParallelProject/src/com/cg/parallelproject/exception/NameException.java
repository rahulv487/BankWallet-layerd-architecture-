package com.cg.parallelproject.exception;

public class NameException extends Exception{
	public NameException() {
		// TODO Auto-generated constructor stub
		super("***Invalid Name declaration***"
				+ "First letter must be capital remaining should be small letter... :)");
	}
}
