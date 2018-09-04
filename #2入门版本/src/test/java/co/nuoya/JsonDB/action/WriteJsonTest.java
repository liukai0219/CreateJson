package co.nuoya.JsonDB.action;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import co.nuoya.JsonDB.DBUtil.DBUtilsTest;

public class WriteJsonTest {
	
	@Before
	public void setUp() throws SQLException {
		Connection conn = DBUtilsTest.getConnection();
		Statement stat = conn.createStatement();
		String sql = "DELETE FROM Customer";
		stat.executeUpdate(sql);
		sql = "DELETE FROM Acount";
		stat.executeUpdate(sql);
		sql = "DELETE FROM Tags";
		stat.executeUpdate(sql);
		sql = "INSERT INTO customer(id, _index, guid, active, acount_id, picture, age, eyecolor, lastName, firstName, company, email, phone, address, about, favoriteFruit) VALUES ('999999999999988','0','05f531f2-ab5a-470f-b77d-9be077909412',0,'148998','http://placehold.it/32x32',31,'blue','Chavez','Christi','ZEROLOGY','christi.chavez@zerology.ca','+1(928)536-3512','889 Stryker Court, Glenbrook, Michigan, 2079','Aliquip eiusmod commodo id aliquip exercitation ut.','apple');";
		stat.executeUpdate(sql);
		sql = "insert into acount values('148998','$12,123',sysdate(),'root',sysdate(),'root');";
		stat.executeUpdate(sql);
		sql = "insert into tags values('123456789','999999999999988','tag1',sysdate(),'root',sysdate(),'root');";
		stat.executeUpdate(sql);
		sql = "insert into tags values('123456788','999999999999988','tag2',sysdate(),'root',sysdate(),'root');";
		stat.executeUpdate(sql);
		DBUtilsTest.closeAll(conn, stat, null);
	}
	
	@Test
	public void writeJson() {
		WriteJson write = new WriteJson();
		String result = write.writeJson();
		assertEquals("[{\"_id\":\"999999999999988\",\"index\":\"0\",\"guid\":\"05f531f2-ab5a-470f-b77d-9be077909412\",\"isActive\":false,\"acount\":{\"acount_id\":\"148998\",\"balance\":\"$12,123\"},\"picture\":\"http://placehold.it/32x32\",\"age\":31,\"eyeColor\":\"blue\",\"lastName\":\"Chavez\",\"firstName\":\"Christi\",\"company\":\"ZEROLOGY\",\"email\":\"christi.chavez@zerology.ca\",\"phone\":\"+1(928)536-3512\",\"address\":\"889 Stryker Court, Glenbrook, Michigan, 2079\",\"about\":\"Aliquip eiusmod commodo id aliquip exercitation ut.\",\"tags\":[{\"id\":\"123456788\",\"customer_id\":\"999999999999988\",\"tag\":\"tag2\"},{\"id\":\"123456789\",\"customer_id\":\"999999999999988\",\"tag\":\"tag1\"}],\"favoriteFruit\":\"apple\"}]", result);
	}
}
