package co.nuoya.JsonDB.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.nuoya.JsonDB.DBUtil.DBUtils;
import co.nuoya.JsonDB.model.Tags;
import co.nuoya.JsonDB.util.Utils;

public class TagsDAOImpl implements TagsDAO {

	@Override
	public List<Tags> select(String customer_id) {
		Utils.getFileLogger().info("select start");
		Utils.getFileLogger().info("paramter customer_id : {} ", customer_id);
		List<Tags> result = new ArrayList<Tags>();
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.selectList("co.nuoya.JsonDB.dao.Tags.selectTags", customer_id);
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result.toString());
		Utils.getFileLogger().info("select end");
		return result;
	}

	@Override
	public int insert(Tags tags) {
		Utils.getFileLogger().info("insert start");
		Utils.getFileLogger().info("paramter tags : {} ", tags.toString());
		int result = 0;
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.insert("co.nuoya.JsonDB.dao.Tags.insertTags", tags);
			session.commit();
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result);
		Utils.getFileLogger().info("insert end");
		return result;
	}

	@Override
	public int update(Tags tags) {
		Utils.getFileLogger().info("update start");
		Utils.getFileLogger().info("paramter acount : {} ", tags.toString());
		int result = 0;
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.update("co.nuoya.JsonDB.dao.Tags.updateTags", tags);
			session.commit();
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result);
		Utils.getFileLogger().info("update end");
		return result;
	}

	@Override
	public int delete(String id) {
		Utils.getFileLogger().info("delete start");
		Utils.getFileLogger().info("paramter id : {} ", id);
		int result = 0;
		SqlSessionFactory  sqlSessionFactory = DBUtils.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.delete("co.nuoya.JsonDB.dao.Tags.deleteTags", id);
			session.commit();
		} finally {
			session.close();
		}
		Utils.getFileLogger().info("result : {} ", result);
		Utils.getFileLogger().info("delete end");
		return result;
	}
	
}
