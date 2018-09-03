package co.nuoya.JsonDB.service;

import java.util.List;

import co.nuoya.JsonDB.dao.AcountDAOImpl;
import co.nuoya.JsonDB.model.Acount;

public class AcountServiceImpl implements AcountService{

	@Override
	public List<Acount> select(String acount_id) {
		return new AcountDAOImpl().select(acount_id);
	}

	@Override
	public int insert(Acount acount) {
		return new AcountDAOImpl().insert(acount);
	}

	@Override
	public int update(Acount acount) {
		return new AcountDAOImpl().update(acount);
	}

	@Override
	public int delete(String acount_id) {
		return new AcountDAOImpl().delete(acount_id);
	}

}
