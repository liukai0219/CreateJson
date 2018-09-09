package co.nuoya.JsonDB.action;

import java.util.ArrayList;
import java.util.List;

import co.nuoya.JsonDB.model.Customer;
import co.nuoya.JsonDB.service.CustomerService;
import co.nuoya.JsonDB.service.CustomerServiceImpl;
import co.nuoya.JsonDB.util.Utils;

public class ReadJson {
	
	public List<String> readJson(String path){
		Utils.getFileLogger().info("readJson start");
		Utils.getsFileFormatterLogger().info("paramter path : %s",path);
		//也可以使用以下格式
		//Utils.getFileLogger().info("paramter path : {}",path);
		//Utils.getFileLogger().printf(Level.INFO, "paramter path : %s",path);
		/**
		 * DB操作结果
		 */
		List<String> result = new ArrayList<String>();
		/**
		 * 从json文件中读取数据，生成list
		 */
		List<Customer> customer = Utils.readJsonToList(path,Customer.class);
		
		CustomerService custService = new CustomerServiceImpl();
		customer.forEach($->{
			switch ($.getOperate()) {
			case "add":
				Utils.getsFileFormatterLogger().debug("insert customer data : %s", $.toString());
				result.add(addCutomer(custService, $));
				Utils.getsFileFormatterLogger().info("the result of insert customer data : %s",result.get(result.size()-1));
			break;
			case "del":
				Utils.getsFileFormatterLogger().debug("delete customer data : %s", $.toString());
				result.add(deleteCustomer(custService, $));
				Utils.getsFileFormatterLogger().info("the result of delete customer data : %s",result.get(result.size()-1));
				break;
			case "upd":
				Utils.getsFileFormatterLogger().debug("update customer data : %s", $.toString());
				result.add(updateCustomer(custService, $));
				Utils.getsFileFormatterLogger().info("the result of update customer data : %s",result.get(result.size()-1));
				break;
			}
		});
		Utils.getFileLogger().info("readJson end");
		return result;
	}

	public String updateCustomer(CustomerService custService, Customer customer) {
		Utils.getFileLogger().debug("updateCustomer start");
		Utils.getsFileFormatterLogger().debug("paramter custService : %s ; customer : %s", custService.toString(), customer.toString());
		if (isCustomerExist(customer.getId())) {
			if (custService.updateCustomer(customer) == 1) {
				Utils.getFileLogger().debug("updateCustomer result : {}","更新成功");
				Utils.getFileLogger().debug("updateCustomer end");
				return "更新成功";
			}
		} else {
			Utils.getFileLogger().debug("updateCustomer result : {}","顾客不存在");
			Utils.getFileLogger().debug("updateCustomer end");
			return "顾客不存在";
		}
		Utils.getFileLogger().debug("updateCustomer result : {}","更新失败");
		Utils.getFileLogger().debug("updateCustomer end");
		return "更新失败";
	}

	public String deleteCustomer(CustomerService custService, Customer customer) {
		Utils.getFileLogger().debug("deleteCustomer start");
		Utils.getsFileFormatterLogger().debug("paramter custService : %s ; customer : %s", custService.toString(), customer.toString());
		if (isCustomerExist(customer.getId())) {
			if (custService.deleteCustomer(customer.getId()) == 1) {
				Utils.getFileLogger().debug("deleteCustomer result : {}","删除成功");
				Utils.getFileLogger().debug("deleteCustomer end");
				return "删除成功";
			}
		} else {
			Utils.getFileLogger().debug("deleteCustomer result : {}","顾客不存在");
			Utils.getFileLogger().debug("deleteCustomer end");
			return "顾客不存在";
		}
		Utils.getFileLogger().debug("deleteCustomer result : {}","删除失败");
		Utils.getFileLogger().debug("deleteCustomer end");
		return "删除失败";
	}

	public String addCutomer(CustomerService custService, Customer customer) {
		Utils.getFileLogger().debug("addCutomer start");
		Utils.getsFileFormatterLogger().debug("paramter custService : %s ; customer : %s", custService.toString(), customer.toString());
		if (!isCustomerExist(customer.getId())) {
			if (custService.addCustomer(customer) == 1) {
				Utils.getFileLogger().debug("addCutomer result : {}","添加成功");
				Utils.getFileLogger().debug("addCutomer end");
				return "添加成功";
			}
		} else {
			Utils.getFileLogger().debug("addCutomer result : {}","顾客已存在");
			Utils.getFileLogger().debug("addCutomer end");
			return "顾客已存在";
		}
		Utils.getFileLogger().debug("addCutomer result : {}","添加失败");
		Utils.getFileLogger().debug("addCutomer end");
		return "添加失败";
	}

	/**
	 * 查看顾客是否存在
	 * @param id 顾客ID
	 * @return true：存在    false：不存在
	 */
	private boolean isCustomerExist(String id) {
		Utils.getFileLogger().debug("isCustomerExist start");
		Utils.getsFileFormatterLogger().debug("paramter id : %s ", id);
		CustomerService custService = new CustomerServiceImpl();
		List<Customer> result = custService.findCustomer(id);
		Utils.getFileLogger().debug("result : {}",result.size() > 0 ? true : false);
		Utils.getFileLogger().debug("isCustomerExist end");
		return result.size() > 0 ? true : false;
	}
	/**
	 * 删除顾客信息
	 */
	public int deleteDB() {
		Utils.getFileLogger().info("deleteDB start");
		CustomerService custService = new CustomerServiceImpl();
		int result = custService.deleteCustomer(null);
		Utils.getFileLogger().info("result : {} ", result);
		Utils.getFileLogger().info("deleteDB end");
		return result;
	}
	/**
	 * 查询并输出所有顾客信息
	 */
	public List<Customer> findAllCustomer() {
		Utils.getFileLogger().info("findAllCustomer start");
		CustomerService custService = new CustomerServiceImpl();
		List<Customer> result = custService.findCustomer(null);
		Utils.getFileLogger().info("result : {} ", result.toString());
		Utils.getFileLogger().info("findAllCustomer end");
		return result;
	}
}

