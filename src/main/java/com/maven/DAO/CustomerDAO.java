package com.maven.DAO;

import java.sql.SQLException;
import java.util.List;

import com.maven.bean.Customer;

public interface CustomerDAO extends BaseDAO {
	public List<Customer> findCustomer() throws SQLException;
	public boolean addCustomer(Customer cus) throws SQLException;
}
