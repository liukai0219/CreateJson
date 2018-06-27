package com.maven.DAO;

import java.util.List;

import com.maven.bean.Customer;

public interface CustomerDAO extends BaseDAO {
	public List<Customer> findCustomer(String id);
	public boolean updateCustomer(Customer cus);
	public boolean addCustomer(Customer cus);
	public boolean deleteCustomer(String id);
}
