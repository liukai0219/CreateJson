package co.nuoya.JsonDB.action;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import co.nuoya.JsonDB.model.Customer;
import co.nuoya.JsonDB.service.CustomerService;
import co.nuoya.JsonDB.service.CustomerServiceImpl;
import co.nuoya.JsonDB.util.Utils;

public class ReadJson {
	
	public List<String> readJson(String path){
		/**
		 * DB操作结果
		 */
		List<String> result = new ArrayList<String>();
		/**
		 * 从json文件中读取数据，生成list
		 */
		Type collectionType = new TypeToken<List<Customer>>(){}.getType();
		List<Customer> customer = Utils.readJsonToList(path,collectionType);
		
		CustomerService custService = new CustomerServiceImpl();
		customer.forEach($->{
			
			switch ($.getOperate()) {
			case "add":
				result.add(addCutomer(custService, $));
			break;
			case "del":
				result.add(deleteCustomer(custService, $));
				break;
			case "upd":
				result.add(updateCustomer(custService, $));
				break;
			}
		});
		return result;
	}

	public String updateCustomer(CustomerService custService, Customer customer) {
		if (isCustomerExist(customer.getId())) {
			if (custService.updateCustomer(customer) == 1) {
				return "更新成功";
			}
		} else {
			return "顾客不存在";
		}
		return "更新失败";
	}

	public String deleteCustomer(CustomerService custService, Customer customer) {
		if (isCustomerExist(customer.getId())) {
			if (custService.deleteCustomer(customer.getId()) == 1) {
				return "删除成功";
			}
		} else {
			return "顾客不存在";
		}
		return "删除失败";
	}

	public String addCutomer(CustomerService custService, Customer customer) {
		if (!isCustomerExist(customer.getId())) {
			if (custService.addCustomer(customer) == 1) {
				return "添加成功";
			}
		} else {
			return "顾客已存在";
		}
		return "添加失败";
	}

	/**
	 * 查看顾客是否存在
	 * @param id 顾客ID
	 * @return true：存在    false：不存在
	 */
	private boolean isCustomerExist(String id) {
		CustomerService custService = new CustomerServiceImpl();
		List<Customer> result = custService.findCustomer(id);
		return result.size() > 0 ? true : false;
	}
	/**
	 * 删除顾客信息
	 */
	public int deleteDB() {
		CustomerService custService = new CustomerServiceImpl();
		return custService.deleteCustomer(null);
	}
	/**
	 * 查询并输出所有顾客信息
	 */
	public List<Customer> findAllCustomer() {
		CustomerService custService = new CustomerServiceImpl();
		return custService.findCustomer(null);
	}
}

