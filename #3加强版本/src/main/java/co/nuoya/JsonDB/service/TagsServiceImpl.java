package co.nuoya.JsonDB.service;

import java.util.List;

import co.nuoya.JsonDB.dao.TagsDAOImpl;
import co.nuoya.JsonDB.model.Tags;

public class TagsServiceImpl implements TagsService{

	@Override
	public List<Tags> select(String customer_id) {
		return new TagsDAOImpl().select(customer_id);
	}

	@Override
	public int insert(Tags tags) {
		return new TagsDAOImpl().insert(tags);
	}

	@Override
	public int update(Tags tags) {
		return new TagsDAOImpl().update(tags);
	}

	@Override
	public int delete(String id) {
		return new TagsDAOImpl().delete(id);
	}

}
