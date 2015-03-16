package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.model.HomePage;

public interface IHomePageDao {
	public boolean create(HomePage hp);
	public boolean update(String key, HomePage hp);
	public boolean delete(String key);
	public HomePage findHomeById(String key);
	
}
