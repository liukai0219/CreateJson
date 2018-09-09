package co.nuoya.JsonDB.action;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Before;
import org.junit.Test;

import co.nuoya.JsonDB.util.Utils;

public class WriteJsonTest {
	
	@Before
	public void setUp() throws SQLException, ClassNotFoundException, IOException {
		Utils.getFileLogger().info("setUp start");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/json_Mybatis", "root", "572165");
	    Reader reader = Resources.getResourceAsReader("./CreateDBForWriteTest.sql");
	    
	    ScriptRunner runner = new ScriptRunner(conn);
	    runner.setLogWriter(null);
	    runner.setErrorLogWriter(null);
	    runner.runScript(reader);
	    conn.commit();
	    reader.close();
		Utils.getFileLogger().info("setUp end");
	}
	
	@Test
	public void writeJson() {
		Utils.getFileLogger().info("writeJson start");
		WriteJson write = new WriteJson();
		String result = write.writeJson();
		assertEquals("[{\"_id\":\"999999999999988\",\"index\":\"0\",\"guid\":\"05f531f2-ab5a-470f-b77d-9be077909412\",\"isActive\":false,\"acount\":{\"acount_id\":\"148998\",\"balance\":\"$12,123\"},\"picture\":\"http://placehold.it/32x32\",\"age\":31,\"eyeColor\":\"blue\",\"lastName\":\"Chavez\",\"firstName\":\"Christi\",\"company\":\"ZEROLOGY\",\"email\":\"christi.chavez@zerology.ca\",\"phone\":\"+1(928)536-3512\",\"address\":\"889 Stryker Court, Glenbrook, Michigan, 2079\",\"about\":\"Aliquip eiusmod commodo id aliquip exercitation ut.\",\"tags\":[{\"id\":\"123456788\",\"customer_id\":\"999999999999988\",\"tag\":\"tag2\"},{\"id\":\"123456789\",\"customer_id\":\"999999999999988\",\"tag\":\"tag1\"}],\"favoriteFruit\":\"apple\"}]", result);
		Utils.getFileLogger().info("writeJson end");
	}
}
