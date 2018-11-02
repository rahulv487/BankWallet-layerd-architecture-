package com.cg.parallelproject.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.parallelproject.dto.Customer;

public class DataContainer {

	private static Map<String, Customer> maps;

	public static Map<String, Customer> createCollection() {

		if (maps == null)
			maps = new HashMap<String, Customer>();

		return maps;
	}

}
