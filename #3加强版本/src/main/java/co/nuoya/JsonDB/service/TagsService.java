package co.nuoya.JsonDB.service;

import java.util.List;

import co.nuoya.JsonDB.model.Tags;

public interface TagsService {
	public List<Tags> select(String customer_id);
	public int insert(Tags tags);
	public int update(Tags tags);
	public int delete(String id);
}
