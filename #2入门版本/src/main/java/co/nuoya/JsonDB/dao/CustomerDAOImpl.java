package co.nuoya.JsonDB.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.nuoya.JsonDB.DBUtil.DBUtils;
import co.nuoya.JsonDB.model.Customer;
import co.nuoya.JsonDB.util.Utils;

public class CustomerDAOImpl implements CustomerDAO {
	/**
	 * 查询顾客表
	 * @param id 顾客ID 当id为null时返回所有顾客
	 * @return list 顾客列表
	 */
	@Override
	public List<Customer> findCustomer(String id) {
		Utils.getFileLogger().info("findCustomer start");
		Utils.getFileLogger().info("paramter id : {} ", id);
		List<Customer> list = new ArrayList<Customer>();
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			list = session.selectList("co.nuoya.JsonDB.dao.Customer.selectCustomer", id);
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", list.toString());
		Utils.getFileLogger().info("findCustomer end");
		return list;
	}
	
	/**
	 * 查询顾客表
	 * @param map 查询条件
	 * @return list 顾客列表
	 */
	@Override
	public List<Customer> findCustomerByAgeAndActive(Map<String, Object> map) {
		Utils.getFileLogger().info("findCustomerByAgeAndActive start");
		Utils.getFileLogger().info("paramter map : {} ", map.toString());
		List<Customer> list = new ArrayList<Customer>();
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			list = session.selectList("co.nuoya.JsonDB.dao.Customer.selectCustomerByAgeAndActive", map);
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", list.toString());
		Utils.getFileLogger().info("findCustomerByAgeAndActive end");
		return list;
	}
	
	/**
	 * 查询顾客表
	 * @param map 查询条件
	 * @return result 顾客列表
	 */
	@Override
	public List<Customer> findCustomerByAny(Map<String,Object> map) {
		Utils.getFileLogger().info("findCustomerByAny start");
		Utils.getFileLogger().info("paramter map : {} ", map.toString());
		List<Customer> result = new ArrayList<Customer>();
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.selectList("co.nuoya.JsonDB.dao.Customer.selectCustomerByAny", map);
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result.toString());
		Utils.getFileLogger().info("findCustomerByAny end");
		return result;
	}
	
	/**
	 * 查询顾客表
	 * @param list 查询条件
	 * @return result 顾客列表
	 */
	@Override
	public List<Customer> findCustomerByName(List<String> list) {
		Utils.getFileLogger().info("findCustomerByName start");
		Utils.getFileLogger().info("paramter id : {} ", list.toString());
		List<Customer> result = new ArrayList<Customer>();
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.selectList("co.nuoya.JsonDB.dao.Customer.selectCustomerByName", list);
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result.toString());
		Utils.getFileLogger().info("findCustomerByName end");
		return result;
	}
	
	/**
	 * 查询顾客表
	 * @param list 查询条件
	 * @return result 顾客列表
	 */
	@Override
	public List<Customer> findCustomerByName(String[] params) {
		Utils.getFileLogger().info("findCustomerByName start");
		Utils.getFileLogger().info("paramter params : {} ", params.toString());
		List<Customer> result = new ArrayList<Customer>();
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.selectList("co.nuoya.JsonDB.dao.Customer.selectCustomerByName_Array", params);
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result.toString());
		Utils.getFileLogger().info("findCustomerByName end");
		return result;
	}
	

	@Override
	public List<Customer> findCustomerByName(String param) {
		Utils.getFileLogger().info("findCustomerByName start");
		Utils.getFileLogger().info("paramter param : {} ", param);
		List<Customer> result = new ArrayList<Customer>();
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.selectList("co.nuoya.JsonDB.dao.Customer.selectCustomerByName_Like", param);
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result.toString());
		Utils.getFileLogger().info("findCustomerByName end");
		return result;
	}
	
	/**
	 * 更新顾客信息
	 * @param cus 顾客实例
	 * @return 1 ：成功 其他：失败
	 */
	@Override
	public int updateCustomer(Customer cus) {
		Utils.getFileLogger().info("updateCustomer start");
		Utils.getFileLogger().info("paramter cus : {} ", cus.toString());
		int result = -1;
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.update("co.nuoya.JsonDB.dao.Customer.updateCustomer", cus);
			session.commit();
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result);
		Utils.getFileLogger().info("updateCustomer end");
		return result;
	}

	/**
	 * 插入顾客信息
	 * @param cus 顾客实例
	 * @return 1 ：成功 其他：失败
	 */
	@Override
	public int addCustomer(Customer cus) {
		Utils.getFileLogger().info("addCustomer start");
		Utils.getFileLogger().info("paramter cus : {} ", cus.toString());
		int result = -1;
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.insert("co.nuoya.JsonDB.dao.Customer.insertCustomer", cus);
			session.commit();
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result);
		Utils.getFileLogger().info("addCustomer end");
		return result;
	}
	
	/**
	 * 删除顾客信息
	 * @param id 顾客ID  为null时删除所有
	 * @return 1 ：成功 其他：失败
	 */
	@Override
	public int deleteCustomer(String id) {
		Utils.getFileLogger().info("deleteCustomer start");
		Utils.getFileLogger().info("paramter id : {} ", id);
		int result = -1;
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.delete("co.nuoya.JsonDB.dao.Customer.deleteCustomer", id);
			session.commit();
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result);
		Utils.getFileLogger().info("deleteCustomer end");
		return result;
	}
}
