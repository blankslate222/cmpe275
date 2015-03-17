package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.model.HomePage;

/**
 * @author Nikhil, Rayan
 *
 */
public interface IHomePageDao {
	/**
	 * @param hp instance of HomePage model which needs to be added to the list
	 * @return true/false indicate whether HomePage created successfully
	 */
	public boolean create(HomePage hp);
	/**
	 * @param key key for the map maintained by the service
	 * @param hp instance of HomePage model which needs to be updated
	 * @return true/false indicate whether HomePage updated successfully
	 */
	public boolean update(String key, HomePage hp);
	/**
	 * @param key user id of the HomePage that is to be deleted
	 * @return true/false indicate whether HomePage deleted successfully
	 */
	public boolean delete(String key);
	/**
	 * @param key userId as the key for query
	 * @return HomePage record
	 */
	public HomePage findHomeById(String key);
	
}
