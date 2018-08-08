package co.nuoya.JsonDB.action;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import co.nuoya.JsonDB.DBUtil.DBUtils;

public class WriteJsonTest{
	
	@Before
	public void setUp() throws SQLException {
		Connection conn = DBUtils.getConnection();
		Statement stat = conn.createStatement();
		String sql = "DELETE FROM Customer";
		stat.executeUpdate(sql);
		sql = "INSERT INTO `customer`(`id`, `_index`, `guid`, `active`, `balance`, `picture`, `age`, `eyecolor`, `lastName`, `firstName`, `company`, `email`, `phone`, `address`, `about`, `favoriteFruit`) VALUES ('999999999999999','0','05f531f2-ab5a-470f-b77d-9be077909412',0,'$1,489.98','http://placehold.it/32x32',31,'blue','Chavez','Christi','ZEROLOGY','christi.chavez@zerology.ca','+1(928)536-3512','889 Stryker Court, Glenbrook, Michigan, 2079','Aliquip eiusmod commodo id aliquip exercitation ut.','apple');";
		stat.executeUpdate(sql);
	}
	
	@Test
	public void writeJson() {
		WriteJson write = new WriteJson();
		String result = write.writeJson();
		assertEquals("[{\"_id\":\"999999999999999\",\"index\":\"0\",\"guid\":\"05f531f2-ab5a-470f-b77d-9be077909412\",\"isActive\":false,\"balance\":\"$1,489.98\",\"picture\":\"http://placehold.it/32x32\",\"age\":31,\"eyeColor\":\"blue\",\"lastName\":\"Chavez\",\"firstName\":\"Christi\",\"company\":\"ZEROLOGY\",\"email\":\"christi.chavez@zerology.ca\",\"phone\":\"+1(928)536-3512\",\"address\":\"889 Stryker Court, Glenbrook, Michigan, 2079\",\"about\":\"Aliquip eiusmod commodo id aliquip exercitation ut.\",\"favoriteFruit\":\"apple\"}]", result);
	}
}
