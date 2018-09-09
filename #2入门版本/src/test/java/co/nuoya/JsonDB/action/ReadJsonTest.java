package co.nuoya.JsonDB.action;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Before;
import org.junit.Test;

import co.nuoya.JsonDB.model.Customer;
import co.nuoya.JsonDB.util.Utils;;

public class ReadJsonTest {
	
	@Before
	public void setUp() throws SQLException, ClassNotFoundException, IOException {
		Utils.getFileLogger().info("setUp start");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/json_Mybatis", "root", "572165");
	    Reader reader = Resources.getResourceAsReader("./CreateDBForReadTest.sql");
	    
	    ScriptRunner runner = new ScriptRunner(conn);
	    runner.setLogWriter(null);
	    runner.setErrorLogWriter(null);
	    runner.runScript(reader);
	    conn.commit();
	    reader.close();
		
		
		
		
		Utils.getFileLogger().info("setUp end");
	}
	
	
	@Test
	public void readJson(){
		Utils.getFileLogger().info("readJson start");
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
		Utils.getFileLogger().info("readJson end");
	}
	
	@Test
	public void findAllCustomer() {
		Utils.getFileLogger().info("findAllCustomer start");
		ReadJson readJson = new ReadJson();
		List<Customer> result = readJson.findAllCustomer();
		
		assertEquals(1,result.size());
		Utils.getFileLogger().info("findAllCustomer end");
	}
	
	@Test
	public void deleteDB() {
		Utils.getFileLogger().info("deleteDB start");
		ReadJson readJson = new ReadJson();
		assertEquals(1,readJson.deleteDB());
		Utils.getFileLogger().info("deleteDB end");
	}
}
