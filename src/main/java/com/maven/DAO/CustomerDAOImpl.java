package com.maven.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.maven.DBUtils.DBUtils;
import com.maven.bean.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	@Override
	public List<Customer> findCustomer(Customer cus) throws SQLException {
		List<Customer> list = new ArrayList<Customer>();
		Connection conn = DBUtils.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM Customer";
		
		
		
		sql = sql + ";";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Customer customer = new Customer();
			customer.setId(rs.getString("id"));
			list.add(customer);
		}
		return list;
	}

	@Override
	public boolean updateCustomer(Customer cus) throws SQLException {
		Connection conn = DBUtils.getConnection();
		Statement stmt = conn.createStatement();
		int isActive = 1;
		if (cus.isActive() == false)
			isActive = 0;
		String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
		String sql = "UPDATE Customer SET "
				+"`active`='"+isActive+"',"
				+"`balance`='"+cus.getBalance()+"',"
				+"`picture`='"+cus.getPicture()+"',"
				+"`age`='"+cus.getAge()+"',"
				+"`eyecolor`='"+cus.getEyecolor()+"',"
				+"`lastName`='"+cus.getLastName()+"',"
				+"`firstName`='"+cus.getFirstName()+"',"
				+"`company`='"+cus.getCompany()+"',"
				+"`email`='"+cus.getEmail()+"',"
				+"`phone`='"+cus.getPhone()+"',"
				+"`address`='"+cus.getAddress()+"',"
				+"`about`='"+cus.getAbout()+"',"
				+"`favoriteFruit`='"+cus.getFavoriteFruit()+"',"
				+"`updated`='"+datetime+"'"
				+"WHERE "
				+"id='"+cus.getId()+"';";
		boolean result = stmt.execute(sql);
		return result;
	}

	@Override
	public boolean addCustomer(Customer cus) throws SQLException {
		Connection conn = DBUtils.getConnection();
		Statement stmt = conn.createStatement();
		int isActive = 1;
		if (cus.isActive() == false)
			isActive = 0;
		String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
		String sql = "INSERT INTO `customer`("
							+ "`id`, "
							+ "`_index`,"
							+ " `guid`, "
							+ "`active`, "
							+ "`balance`, "
							+ "`picture`, "
							+ "`age`, "
							+ "`eyecolor`, "
							+ "`lastName`, "
							+ "`firstName`, "
							+ "`company`, "
							+ "`email`, "
							+ "`phone`, "
							+ "`address`, "
							+ "`about`, "
							+ "`favoriteFruit`, "
							+ "`created`, "
							+ "`createdBy`, "
							+ "`updated`, "
							+ "`updatedBy`"
							+ ") "
							+ "VALUES ("
							+ "'"+cus.getId()+"',"
							+ "'"+cus.getIndex()+"',"
							+ "'"+cus.getGuid()+"',"
							+ "'"+isActive+"',"
							+ "'"+cus.getBalance()+"',"
							+ "'"+cus.getPicture()+"',"
							+ "'"+cus.getAge()+"',"
							+ "'"+cus.getEyecolor()+"',"
							+ "'"+cus.getLastName()+"',"
							+ "'"+cus.getFirstName()+"',"
							+ "'"+cus.getCompany()+"',"
							+ "'"+cus.getEmail()+"',"
							+ "'"+cus.getPhone()+"',"
							+ "'"+cus.getAddress()+"',"
							+ "'"+cus.getAbout()+"',"
							+ "'"+cus.getFavoriteFruit()+"',"
							+ "'"+datetime+"',"
							+ "'root',"
							+ "'"+datetime+"',"
							+ "'root'"
							+ ");";
		boolean result = stmt.execute(sql);
		return result;
	}





}
