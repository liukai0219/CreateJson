package co.nuoya.JsonDB.service;

import java.util.List;

import co.nuoya.JsonDB.model.Customer;

public interface CustomerService {
	public List<Customer> findCustomer(String id);
	public int updateCustomer(Customer cus);
	public int addCustomer(Customer cus);
	public int deleteCustomer(String id);
}
