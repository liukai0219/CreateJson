package co.nuoya.JsonDB.DBUtil;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtils {
	public static volatile SqlSessionFactory sessionFactory = null;

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sessionFactory == null) {
			synchronized (DBUtils.class) {
				if (sessionFactory == null) {
					try {
						String resource = "resources/MybatisConfiguration.xml";
						InputStream inputStream = Resources.getResourceAsStream(resource);
						sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					} 
				}
			}
		}
		return sessionFactory;
	}
}
