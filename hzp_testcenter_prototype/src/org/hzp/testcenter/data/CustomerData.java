package org.hzp.testcenter.data;

import org.hzp.testcenter.model.Customer;

public class CustomerData {
	public static String[][] CUSTOMER_DATA = { 
			{ "hzp@163.com", // userId
			  "123456", // password
			  "hzp@163.com"// email
			}, 
			
			{ "hzp.java@gmail.com", 
			  "hzp123", 
			  "hzp.java@gmail.com" 
			  } 
			};
	
	private static final Customer[] customers;
	
	static {
		int size = CUSTOMER_DATA.length;
		customers = new Customer[size];
		for (int i = 0; i < size; i++) {
			String[] cust = CUSTOMER_DATA[i];
			Customer c = new Customer();
			c.setUserId(cust[0]);
			c.setPassword(cust[1]);
			c.setEmail(cust[2]);
			customers[i] = c;
		}
	}

	public static Customer[] getCustomer() {
		return customers;
	}

}
