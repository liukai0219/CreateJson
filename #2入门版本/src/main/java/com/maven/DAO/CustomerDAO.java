package com.maven.DAO;

import java.util.List;
import java.util.Map;

import com.maven.bean.Customer;

public interface CustomerDAO extends BaseDAO {
	public List<Customer> findCustomer(String id);
	public List<Customer> findCustomerByAgeAndActive(Map<String,Object> map);
	public List<Customer> findCustomerByAny(List<String> list);
	public int updateCustomer(Customer cus);
	public int addCustomer(Customer cus);
	public int deleteCustomer(String id);
}
