package com.maven.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.maven.DBUtils.DBUtils;
import com.maven.bean.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	public List<Customer> findCustomer() throws SQLException {
		Connection conn = DBUtils.getConnection();
		return null;
	}

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
