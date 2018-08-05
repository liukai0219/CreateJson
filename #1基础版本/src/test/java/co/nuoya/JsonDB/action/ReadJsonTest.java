package co.nuoya.JsonDB.action;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import co.nuoya.JsonDB.model.Customer;
import co.nuoya.JsonDB.util.Utils;
import junit.framework.TestCase;
import junit.framework.TestSuite;;


public class ReadJsonTest extends TestCase{
	
	public ReadJsonTest(String name) {
		super(name);
	}
	
	@BeforeClass
	public static void init() {
		Utils.printMsg("init");
		ReadJson readJson = new ReadJson();
		readJson.deleteDB();
	}
	
	public static TestSuite suite() {
		TestSuite suite = new TestSuite(ReadJsonTest.class); 
		suite.addTest(new ReadJsonTest("init"));
		suite.addTest(new ReadJsonTest("readJson"));
		suite.addTest(new ReadJsonTest("findAllCustomer"));
		suite.addTest((junit.framework.Test) new ReadJsonTest("deleteDB"));
		return suite;
	}
	
	@Test
	public void readJson(){
		Utils.printMsg("readJson");
		ReadJson readJson = new ReadJson();
		List<String> result = readJson.readJson("./src/main/resources/customers.json");
		
		assertEquals(14,result.size());
		
	}
	
	@Test
	public void findAllCustomer() {
		Utils.printMsg("findAllCustomer");
		ReadJson readJson = new ReadJson();
		List<Customer> result = readJson.findAllCustomer();
		
		assertEquals(0,result.size());
	}
	
	@Test
	public void deleteDB() {
		Utils.printMsg("deleteDB");
		ReadJson readJson = new ReadJson();
		assertEquals(1,readJson.deleteDB());
	}
}
