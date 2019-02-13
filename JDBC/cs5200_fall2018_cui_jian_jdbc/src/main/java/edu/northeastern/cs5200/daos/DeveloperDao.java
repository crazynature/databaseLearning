package edu.northeastern.cs5200.daos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Developer;

import java.sql.Statement;


public class DeveloperDao implements DeveloperImpl{

	

	public static DeveloperDao instance = null;
	public static DeveloperDao getInstance() {
		if (instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}
	private final String INSERT_PERSON="INSERT INTO person (id, firstName, lastName, username, password, email, dob) "
			+ "VALUES (?,?,?,?,?,?,?)";
	private final String INSERT_DEVELOPER="INSERT INTO developer (id, developer_key) VALUES(?,?)";
	private final String FIND_ALL_DEVELOPER = "SELECT * FROM developer JOIN person ON developer.id = person.id";
	private final String FIND_DEVELOPER_BY_ID = "SELECT * FROM developer JOIN person ON developer.id = person.id WHERE developer.id = ";
	private final String FIND_DEVELOPER_BY_USERNAME = "SELECT * FROM developer JOIN person ON developer.id = person.id WHERE person.username = ";
	private final String FIND_DEVELOPER_BY_USERNAME_AND_PASS = "SELECT * FROM developer JOIN person ON developer.id = person.id WHERE person.username = ? AND person.password = ?";
	private final String UPDATE_PERSON = "UPDATE person SET firstName = ?, lastName = ?, username = ?, password = ?, email = ?, dob = ? WHERE person.id = ?";	
	private final String UPDATE_DEVELOPER = "UPDATE developer SET developerKey = ? WHERE developer.id = ?";
	private final String DELETE_PERSON = "DELETE FROM person WHERE person.id = ";
	private final String DELETE_DEVELOPER = "DELETE FROM developer WHERE developer.id = ";
	
	public void createDeveloper(Developer developer) throws SQLException, ClassNotFoundException {
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(INSERT_PERSON);
		response.setInt(1, developer.getId());
		response.setString(2, developer.getFirstName());
		response.setString(3, developer.getLastName());
		response.setString(4, developer.getUsername());
		response.setString(5, developer.getPassword());
		response.setString(6, developer.getEmail());
		response.setDate(7, developer.getDob());
		response.executeUpdate();
		response = conn.prepareStatement(INSERT_DEVELOPER);
		response.setInt(1, developer.getId());
		response.setString(2, developer.getDeveloperKey());
		response.executeUpdate();
		response.close();
		conn.close();
	}

	public Collection<Developer> findAllDevelopers() throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		Collection<Developer> develpers = new ArrayList<Developer>();
		ResultSet result = response.executeQuery(FIND_ALL_DEVELOPER);
		while (result.next()) {
			Developer develper = new Developer(result.getInt("id"),
					result.getString("firstName"),
					result.getString("lastName"),
					result.getString("username"),
					result.getString("password"),
					result.getString("email"),
					result.getDate("dob"),
					result.getString("developerKey"));
			develpers.add(develper);
		}
		response.close();
		conn.close();
		return develpers;
	}
	
	public Developer findDeveloperById(int developerId) throws ClassNotFoundException, SQLException {
		
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		ResultSet result = response.executeQuery(FIND_DEVELOPER_BY_ID + String.valueOf(developerId));
		Developer developer = null;
		if (result.next()) {
			developer = new Developer(result.getInt("id"),
					result.getString("firstName"),
					result.getString("lastName"),
					result.getString("username"),
					result.getString("password"),
					result.getString("email"),
					result.getDate("dob"),
					result.getString("developerKey"));
		}
		
		response.close();
		conn.close();
		return developer;
	}

	public Developer findDeveloperByUsername(String username) throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		ResultSet result = response.executeQuery(FIND_DEVELOPER_BY_USERNAME+username);
		Developer developer = null;
		if (result.next()) {
			developer = new Developer(result.getInt("id"),
					result.getString("firstName"),
					result.getString("lastName"),
					result.getString("username"),
					result.getString("password"),
					result.getString("email"),
					result.getDate("dob"),
					result.getString("developerKey"));
		}
		response.close();
		conn.close();
		return developer;
	}

	public Developer findDeveloperByCredentials(String username, String password) throws ClassNotFoundException, SQLException {
		
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(FIND_DEVELOPER_BY_USERNAME_AND_PASS);
		response.setString(1, username);
		response.setString(2, password);
		ResultSet result = response.executeQuery();
		Developer developer = null;
		if (result.next()) {
			developer = new Developer(result.getInt("id"),
					result.getString("firstName"),
					result.getString("lastName"),
					result.getString("username"),
					result.getString("password"),
					result.getString("email"),
					result.getDate("dob"),
					result.getString("developerKey"));
		}
		response.close();
		conn.close();
		return developer;
	}
	
	public int updateDeveloper(int developerId, Developer developer) throws SQLException, ClassNotFoundException {
		
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(UPDATE_PERSON);
		response.setString(1, developer.getFirstName());
		response.setString(2, developer.getLastName());
		response.setString(3, developer.getUsername());
		response.setString(4, developer.getPassword());
		response.setString(5, developer.getEmail());
		response.setDate(6, developer.getDob());
		response.setInt(7, developerId);
		int result = response.executeUpdate();
		response = conn.prepareStatement(UPDATE_DEVELOPER);
		response.setString(1, developer.getDeveloperKey());
		response.setInt(2, developerId);
		result = response.executeUpdate();
		response.close();
		conn.close();
		return result;	
	}
	
	public int deleteDeveloper(int developerId) throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		int result = response.executeUpdate(DELETE_PERSON+String.valueOf(developerId));
		response = conn.createStatement();
		result = response.executeUpdate(DELETE_DEVELOPER+String.valueOf(developerId));
		response.close();
		conn.close();
		return result;
		
	}
}