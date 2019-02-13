package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.User;

public class UserDao {


	public static UserDao instance = null;
	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	
	private final String INSERT_PERSON = "INSERT INTO person (id, firstName, lastName, username, password, email, dob) VALUES (?,?,?,?,?,?,?)";
	private final String INSERT_USER = "INSERT INTO user (id, user_agreement) VALUES(?,?)";
	private final String FIND_ALL = "SELECT * FROM user JOIN person ON user.id = person.id";
	
	public void createUser(User user) throws SQLException, ClassNotFoundException {
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(INSERT_PERSON);
		
		response.setInt(1, user.getId());
		response.setString(2, user.getFirstName());
		response.setString(3, user.getLastName());
		response.setString(4, user.getUsername());
		response.setString(5, user.getPassword());
		response.setString(6, user.getEmail());
		response.setDate(7, user.getDob());
		response.executeUpdate();	
		response = conn.prepareStatement(INSERT_USER);
		response.setInt(1, user.getId());
		response.setBoolean(2, user.getUserAgreement());		
		response.executeUpdate();
		response.close();
		conn.close();
	}

	public Collection<User> findAllUsers() throws ClassNotFoundException, SQLException {

		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		Collection<User> users = new ArrayList<User>();
		ResultSet result = response.executeQuery(FIND_ALL);
		while (result.next()) {
			User d = new User(result.getInt("id"),
					result.getString("firstName"),
					result.getString("lastName"),
					result.getString("username"),
					result.getString("password"),
					result.getString("email"),
					result.getDate("dob"),
					result.getBoolean("userAgreement"));
			users.add(d);
		}
		
		response.close();
		conn.close();
		return users;
	}
	



	
}