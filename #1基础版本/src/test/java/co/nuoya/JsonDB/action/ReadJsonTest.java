package co.nuoya.JsonDB.action;

import java.util.List;

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
		suite.addTest(new ReadJsonTest("deleteDB"));
		suite.addTest(TestSuite.createTest(WriteJsonTest.class, "init"));
		suite.addTest(TestSuite.createTest(WriteJsonTest.class, "writeJson"));
		return suite;
	}
	
	@Test
	public void readJson(){
		Utils.printMsg("readJson");
		ReadJson readJson = new ReadJson();
		List<String> result = readJson.readJson("./src/main/resources/customers.json");
		
		assertEquals(14,result.size());
		//成功添加
		assertEquals("添加成功",result.get(0));
		assertEquals("添加成功",result.get(1));
		assertEquals("添加成功",result.get(2));
		assertEquals("添加成功",result.get(3));
		assertEquals("添加成功",result.get(4));
		assertEquals("添加成功",result.get(5));
		assertEquals("添加成功",result.get(6));
		//更新成功
		assertEquals("更新成功",result.get(7));
		assertEquals("更新成功",result.get(8));
		//删除成功
		assertEquals("删除成功",result.get(9));
		assertEquals("删除成功",result.get(10));
		//操作不成功
		assertEquals("顾客不存在",result.get(11));
		assertEquals("顾客不存在",result.get(12));
		assertEquals("顾客已存在",result.get(13));
		
	}
	
	@Test
	public void findAllCustomer() {
		Utils.printMsg("findAllCustomer");
		ReadJson readJson = new ReadJson();
		List<Customer> result = readJson.findAllCustomer();
		
		assertEquals(5,result.size());
	}
	
	@Test
	public void deleteDB() {
		Utils.printMsg("deleteDB");
		ReadJson readJson = new ReadJson();
		assertEquals(5,readJson.deleteDB());
	}
}
