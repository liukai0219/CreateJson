package co.nuoya.JsonDB.dao;

import java.util.List;

import co.nuoya.JsonDB.model.Tags;

public interface TagsDAO extends BaseDAO {
	public List<Tags> select(String customer_id);
	public int insert(Tags tags);
	public int update(Tags tags);
	public int delete(String id);
}
