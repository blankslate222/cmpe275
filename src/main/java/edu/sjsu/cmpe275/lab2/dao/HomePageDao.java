package edu.sjsu.cmpe275.lab2.dao;

import java.util.HashMap;
import java.util.Map;
import edu.sjsu.cmpe275.lab2.model.HomePage;

public class HomePageDao implements IHomePageDao{

	private Map<String, HomePage> db = new HashMap<String, HomePage>();

	public boolean create(HomePage hp) {
		boolean retVal = false;
		String key = hp.getId();
		if(db.put(key, hp) == null){
			retVal = true;
		}
		return retVal;
	}

	public boolean update(String key, HomePage hp) {
		boolean retVal = false;
		HomePage ret = db.put(key, hp);
		if( ret != null){
			retVal = true;			
		}
		return retVal;
	}

	public boolean delete(String key) {
		boolean retVal = false;
		if(db.remove(key) != null){
			retVal = true;
		}
		return retVal;
	}

	public HomePage findHomeById(String id) {
		HomePage page = null;
		page = db.get(id);
		return page;
	}

}
