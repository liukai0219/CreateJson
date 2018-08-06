package co.nuoya.JsonDB.action;

import org.junit.BeforeClass;
import org.junit.Test;

import co.nuoya.JsonDB.model.Customer;
import co.nuoya.JsonDB.service.CustomerService;
import co.nuoya.JsonDB.service.CustomerServiceImpl;
import junit.framework.TestCase;

public class WriteJsonTest  extends TestCase{
	@BeforeClass
	public static void init() {
		CustomerService custService = new CustomerServiceImpl();
		Customer customer = new Customer();
		customer.setId("123456789");
		customer.setIndex("11"); 
		customer.setGuid("fkerjwfr"); 
		customer.setAge(18); 
		customer.setActive(true); 
		customer.setBalance("22,222"); 
		customer.setPicture("Picture"); 
		customer.setEyecolor("blue"); 
		customer.setLastName("last"); 
		customer.setFirstName("first"); 
		customer.setCompany("my company"); 
		customer.setEmail("email@e.com"); 
		customer.setPhone("11111"); 
		customer.setAddress("addressaddress"); 
		customer.setAbout("about about"); 
		customer.setFavoriteFruit("apple"); 
		custService.addCustomer(customer);
	}
	
	@Test
	public void writeJson() {
		WriteJson write = new WriteJson();
		String result = write.writeJson();
		assertEquals("[{\"_id\":\"123456789\",\"index\":\"11\",\"guid\":\"fkerjwfr\",\"isActive\":true,\"balance\":\"22,222\",\"picture\":\"Picture\",\"age\":18,\"eyeColor\":\"blue\",\"lastName\":\"last\",\"firstName\":\"first\",\"company\":\"my company\",\"email\":\"email@e.com\",\"phone\":\"11111\",\"address\":\"addressaddress\",\"about\":\"about about\",\"favoriteFruit\":\"apple\"}]", result);
	}
}
