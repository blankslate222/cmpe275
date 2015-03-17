package edu.sjsu.cmpe275.lab2.dao;

import java.util.HashMap;
import java.util.Map;
import edu.sjsu.cmpe275.lab2.model.HomePage;

/**
 * @author Nikhil, Rayan
 *
 */

public class HomePageDao implements IHomePageDao{

	private Map<String, HomePage> db = new HashMap<String, HomePage>();

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.IHomePageDao#create(edu.sjsu.cmpe275.lab2.model.HomePage)
	 */
	public boolean create(HomePage hp) {
		boolean retVal = false;
		String key = hp.getId();
		if(db.put(key, hp) == null){
			retVal = true;
		}
		return retVal;
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.IHomePageDao#update(java.lang.String, edu.sjsu.cmpe275.lab2.model.HomePage)
	 */
	public boolean update(String key, HomePage hp) {
		boolean retVal = false;
		HomePage ret = db.put(key, hp);
		if( ret != null){
			retVal = true;			
		}
		return retVal;
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.IHomePageDao#delete(java.lang.String)
	 */
	public boolean delete(String key) {
		boolean retVal = false;
		if(db.remove(key) != null){
			retVal = true;
		}
		return retVal;
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.IHomePageDao#findHomeById(java.lang.String)
	 */
	public HomePage findHomeById(String id) {
		HomePage page = null;
		page = db.get(id);
		return page;
	}

}
