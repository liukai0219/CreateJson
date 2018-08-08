package co.nuoya.JsonDB.action;

import java.util.List;

import co.nuoya.JsonDB.model.Customer;
import co.nuoya.JsonDB.service.CustomerService;
import co.nuoya.JsonDB.service.CustomerServiceImpl;
import co.nuoya.JsonDB.util.Utils;

public class WriteJson {
	public String writeJson() {
		CustomerService custService = new CustomerServiceImpl();
		List<Customer> result = custService.findCustomer(null);
		
		return Utils.writeListToJson(result);
	}
}
