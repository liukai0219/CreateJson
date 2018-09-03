package co.nuoya.JsonDB.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.nuoya.JsonDB.DBUtil.DBUtils;
import co.nuoya.JsonDB.model.Acount;
import co.nuoya.JsonDB.util.Utils;

public class AcountDAOImpl implements AcountDAO {

	@Override
	public List<Acount> select(String acount_id) {
		Utils.getFileLogger().info("select start");
		Utils.getFileLogger().info("paramter acount_id : {} ", acount_id);
		List<Acount> result = new ArrayList<Acount>();
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.selectList("co.nuoya.JsonDB.dao.Acount.selectAcount", acount_id);
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result.toString());
		Utils.getFileLogger().info("select end");
		return result;
	}

	@Override
	public int insert(Acount acount) {
		Utils.getFileLogger().info("insert start");
		Utils.getFileLogger().info("paramter acount : {} ", acount.toString());
		int result = 0;
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.insert("co.nuoya.JsonDB.dao.Acount.selectAcount", acount);
			session.commit();
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result);
		Utils.getFileLogger().info("insert end");
		return result;
	}

	@Override
	public int update(Acount acount) {
		Utils.getFileLogger().info("update start");
		Utils.getFileLogger().info("paramter acount : {} ", acount.toString());
		int result = 0;
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.update("co.nuoya.JsonDB.dao.Acount.updateAcount", acount);
			session.commit();
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result);
		Utils.getFileLogger().info("update end");
		return result;
	}

	@Override
	public int delete(String acount_id) {
		Utils.getFileLogger().info("delete start");
		Utils.getFileLogger().info("paramter acount_id : {} ", acount_id);
		int result = 0;
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.delete("co.nuoya.JsonDB.dao.Acount.deleteAcount", acount_id);
			session.commit();
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result);
		Utils.getFileLogger().info("delete end");
		return result;
	}

}
