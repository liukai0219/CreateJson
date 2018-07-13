package com.maven.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.maven.DBUtils.DBUtils;
import com.maven.bean.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	/**
	 * 查询顾客表
	 * @param id 顾客ID 当id为null时返回所有顾客
	 * @return list 顾客列表
	 */
	@Override
	public List<Customer> findCustomer(String id) {
		List<Customer> list = new ArrayList<Customer>();
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			list = session.selectList("com.maven.bean.Customer.selectCustomer", id);
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
	/**
	 * 查询顾客表
	 * @param map 查询条件
	 * @return list 顾客列表
	 */
	@Override
	public List<Customer> findCustomerByAgeAndActive(Map<String, Object> map) {
		List<Customer> list = new ArrayList<Customer>();
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			list = session.selectList("com.maven.bean.Customer.selectCustomerByAgeAndActive", map);
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
	@Override
	public List<Customer> findCustomerByAny(List<String> list) {
		List<Customer> result = new ArrayList<Customer>();
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			list = session.selectList("com.maven.bean.Customer.selectCustomerByAny", list);
			session.commit();
		} finally {
			session.close();
		}
		return result;
	}
	
	/**
	 * 更新顾客信息
	 * @param cus 顾客实例
	 * @return 1 ：成功 其他：失败
	 */
	@Override
	public int updateCustomer(Customer cus) {
		int result = -1;
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.update("com.maven.bean.Customer.updateCustomer", cus);
			session.commit();
		} finally {
			session.close();
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
		int result = -1;
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.insert("com.maven.bean.Customer.insertCustomer", cus);
			session.commit();
		} finally {
			session.close();
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
		int result = -1;
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.delete("com.maven.bean.Customer.deleteCustomer", id);
			session.commit();
		} finally {
			session.close();
		}
		return result;
	}
}
