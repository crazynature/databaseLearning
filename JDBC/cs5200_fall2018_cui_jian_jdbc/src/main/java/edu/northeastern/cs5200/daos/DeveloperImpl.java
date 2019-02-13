package edu.northeastern.cs5200.daos;

import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.models.Developer;


public interface DeveloperImpl {

	public void createDeveloper(Developer developer)throws SQLException, ClassNotFoundException;
	public Collection<Developer> findAllDevelopers()throws SQLException, ClassNotFoundException;
	public Developer findDeveloperById(int developerId) throws ClassNotFoundException, SQLException;
	public Developer findDeveloperByUsername(String username)throws ClassNotFoundException, SQLException;
	public Developer findDeveloperByCredentials(String usuername,String password) throws ClassNotFoundException, SQLException;
	public int updateDeveloper(int developerId, Developer developer) throws SQLException, ClassNotFoundException;
	public int deleteDeveloper(int developerId)throws SQLException, ClassNotFoundException;;
	
	
}
