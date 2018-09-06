package co.nuoya.JsonDB.action;

import java.util.List;

import co.nuoya.JsonDB.model.Customer;
import co.nuoya.JsonDB.service.CustomerService;
import co.nuoya.JsonDB.service.CustomerServiceImpl;
import co.nuoya.JsonDB.util.Utils;

public class WriteJson {
	public String writeJson() {
		Utils.getFileLogger().info("writeJson start");
		CustomerService custService = new CustomerServiceImpl();
		List<Customer> resultCust = custService.findCustomer(null);
		
		resultCust.forEach($->{
			
			$.getAccout();
			$.getTags();
			});
		String result = Utils.writeListToJson(resultCust);
		Utils.getFileLogger().info("result : {}", result);
		Utils.getFileLogger().info("writeJson end");
		return result;
	}
}
