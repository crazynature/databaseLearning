package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.Connection;

public class AddressDao {

	public static AddressDao instance = null;
	public static AddressDao getInstance() {
		if(instance == null) {
			instance = new AddressDao();
		}
		return instance;
	}
	
	private final String  DELETE_PRIMARY_ADDRESS= "DELETE from address where address.person_id = ? AND address.primary = ?";
	
	public void deletePrimaryAdderss(int personId) throws ClassNotFoundException, SQLException {
		java.sql.Connection  conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(DELETE_PRIMARY_ADDRESS);
		response.setInt(1, personId);
		response.setBoolean(2, true);
		response.executeUpdate();
		response.close();
		conn.close();
		
	}
}
