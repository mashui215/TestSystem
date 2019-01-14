package org.fangsoft.testcenter.dao;

import org.hzp.testcenter.model.Customer;

public interface CustomerDao {
	public Customer login(String userId,String password);
}
