package co.nuoya.JsonDB.action;

import java.util.List;

import com.google.gson.Gson;

import co.nuoya.JsonDB.model.Customer;
import co.nuoya.JsonDB.service.CustomerService;
import co.nuoya.JsonDB.service.CustomerServiceImpl;

public class WriteJson {
	public String writeJson() {
		CustomerService custService = new CustomerServiceImpl();
		List<Customer> result = custService.findCustomer(null);
		
		Gson gson = new Gson();
		String content = gson.toJson(result);
		return content;
	}
}
