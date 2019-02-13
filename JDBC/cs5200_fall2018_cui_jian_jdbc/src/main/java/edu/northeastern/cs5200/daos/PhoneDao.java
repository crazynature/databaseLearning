package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Phone;

public class PhoneDao {

	public static PhoneDao instance = null;
	public static PhoneDao getInstance() {
		if (instance == null) {
			instance = new PhoneDao();
		}
		return instance;
	}
	private final String FIND_PRIMARY_PHONE="SELECT * FROM phone WHERE phone.person_id = ? and phone.primary = ?";
	private final String UPDATE_PRIMARY_PHONE="UPDATE phone SET id=?, phone = ?  WHERE phone.person_id = ? and phone.primary = ?";
	private final String INSERT_PHONE= "INSERT INTO phone (phone, `primary`,person_id) VALUES (?,?,?)";
	
	public int updatePrimaryPhone(int personId, Phone phone) throws SQLException, ClassNotFoundException {
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(FIND_PRIMARY_PHONE);
		response.setInt(1, personId);
		response.setBoolean(2, true);

		ResultSet result = response.executeQuery();
		if (result.next()) {
			response = conn.prepareStatement(UPDATE_PRIMARY_PHONE);
			response.setInt(1, result.getInt("id"));
			response.setString(2, phone.getPhone());
			response.setInt(3, personId);
			response.setBoolean(4, true);
		}
		else {
			response = conn.prepareStatement(INSERT_PHONE);
			response.setString(1, phone.getPhone());
			response.setBoolean(2, true);
			response.setInt(3, personId);
		}
		int res = response.executeUpdate();
		response.close();
		conn.close();
		return res;	
	}
	
	
}
