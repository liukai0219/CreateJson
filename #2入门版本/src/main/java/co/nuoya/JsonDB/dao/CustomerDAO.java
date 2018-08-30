package co.nuoya.JsonDB.dao;

import java.util.List;
import java.util.Map;

import co.nuoya.JsonDB.model.Customer;

public interface CustomerDAO extends BaseDAO {
	public List<Customer> findCustomer(String id);
	public List<Customer> findCustomerByAgeAndActive(Map<String,Object> map);
	public List<Customer> findCustomerByAny(Map<String,Object> map);
	public List<Customer> findCustomerByName(List<String> list);
	public List<Customer> findCustomerByName(String[] list);
	public List<Customer> findCustomerByName(String param);
	public int updateCustomer(Customer cus);
	public int addCustomer(Customer cus);
	public int deleteCustomer(String id);
}
