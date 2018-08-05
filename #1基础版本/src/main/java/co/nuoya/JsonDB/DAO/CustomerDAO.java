package co.nuoya.JsonDB.DAO;

import java.util.List;

import co.nuoya.JsonDB.model.Customer;

public interface CustomerDAO extends BaseDAO {
	public List<Customer> findCustomer(String id);
	public int updateCustomer(Customer cus);
	public int addCustomer(Customer cus);
	public int deleteCustomer(String id);
}
