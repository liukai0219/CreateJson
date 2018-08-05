package co.nuoya.JsonDB.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import co.nuoya.JsonDB.DBUtil.DBUtils;
import co.nuoya.JsonDB.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	/**
	 * 查询顾客表
	 * @param id 顾客ID 当id为null时返回所有顾客
	 * @return list 顾客列表
	 */
	@Override
	public List<Customer> findCustomer(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		List<Customer> list = new ArrayList<Customer>();
		boolean isActive = true;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			if (id != null) {
				sql = "SELECT * FROM Customer where id = '" + id + "';";	
			} else {
				sql = "SELECT * FROM Customer;";	
			}
			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));
				customer.setIndex(rs.getString("_index")); 
				customer.setGuid(rs.getString("guid")); 
				customer.setAge(rs.getInt("age")); 
				if (rs.getInt("active") == 0)
					isActive = false;
				customer.setActive(isActive); 
				customer.setBalance(rs.getString("balance")); 
				customer.setPicture(rs.getString("picture")); 
				customer.setEyecolor(rs.getString("eyecolor")); 
				customer.setLastName(rs.getString("lastName")); 
				customer.setFirstName(rs.getString("firstName")); 
				customer.setCompany(rs.getString("company")); 
				customer.setEmail(rs.getString("email")); 
				customer.setPhone(rs.getString("phone")); 
				customer.setAddress(rs.getString("address")); 
				customer.setAbout(rs.getString("about")); 
				customer.setFavoriteFruit(rs.getString("favoriteFruit")); 
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtils.closeAll(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * 更新顾客信息
	 * @param cus 顾客实例
	 * @return 1 ：成功 其他：失败
	 */
	@Override
	public int updateCustomer(Customer cus) {
		Connection conn = null;
		Statement stmt = null;
		int result = -1;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
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
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtils.closeAll(conn, stmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	/**
	 * 插入顾客信息
	 * @param cus 顾客实例
	 * @return 1 ：成功 其他：失败
	 */
	@Override
	public int addCustomer(Customer cus) {
		Connection conn = null;
		Statement stmt = null;
		int result = -1;
		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
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
			
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtils.closeAll(conn, stmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 删除顾客信息
	 * @param id 顾客ID  为null时删除所有
	 * @return 1 ：成功 其他：失败
	 */
	@Override
	public int deleteCustomer(String id) {
		Connection conn = null;
		Statement stmt = null;
		int result = -1;
		String sql = "";
		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			if (id != null) {
				sql = "DELETE FROM customer WHERE id = '" + id + "';";
			} else {
				sql = "DELETE FROM customer;";	
			}
			
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtils.closeAll(conn, stmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	

	

}
