package org.fangsoft.testcenter.dao.array;

import org.fangsoft.testcenter.dao.CustomerDao;
import org.hzp.testcenter.data.CustomerData;
import org.hzp.testcenter.model.Customer;

public class CustomerArrayDao implements CustomerDao {

	@Override
	public Customer login(String userId, String password) {
		 
		Customer[] customers = CustomerData.getCustomer();
		for (int i = 0; i < customers.length; i++) {
			Customer c = customers[i];
			if (c.getUserId().equals(userId) && c.getPassword().equals(password)) {
				return customers[i];
			}
		}
		return null;
	}
}
