package co.nuoya.JsonDB.service;

import java.util.List;

import co.nuoya.JsonDB.dao.CustomerDAOImpl;
import co.nuoya.JsonDB.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<Customer> findCustomer(String id) {
		return new CustomerDAOImpl().findCustomer(id);
	}

	@Override
	public int updateCustomer(Customer cus) {
		return new CustomerDAOImpl().updateCustomer(cus);
	}

	@Override
	public int addCustomer(Customer cus) {
		return new CustomerDAOImpl().addCustomer(cus);
	}

	@Override
	public int deleteCustomer(String id) {
		return new CustomerDAOImpl().deleteCustomer(id);
	}

}
