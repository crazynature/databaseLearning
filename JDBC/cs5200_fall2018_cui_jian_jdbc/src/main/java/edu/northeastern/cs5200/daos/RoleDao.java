package edu.northeastern.cs5200.daos;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Role;

public class RoleDao {
	
	public static RoleDao instance = null;
	public static RoleDao getInstance() {
		if (instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}
	
	private String INSERT_WBESITE_ROLE = "INSERT Into website_role (website_id, role, developer_id) VALUES (?,?,?)";
	private String INSERT_PAGE_ROLE = "INSERT Into page_role (page_id, developer_id, role) VALUES (?,?,?)";
	private String DELETE_WEBSITE_ROLE = "DELETE FROM website_role WHERE developer_id=? AND website_id=? AND role=?";
	private String DELETE_PAGE_ROLE = "DELETE FROM page_role WHERE developer_id=? AND page_id=? AND role=?";
	public int assignWebsiteRole(int developerId, int websiteId, int role) throws SQLException, ClassNotFoundException {
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(INSERT_WBESITE_ROLE);
		response.setInt(1, websiteId);
		response.setString(2, Role.getRole(role));
		response.setInt(3, developerId);
		int result = response.executeUpdate();
		response.close();
		conn.close();
		return result;
	}
	
	public int assignPageRole(int developerId, int pageId, int role) throws SQLException, ClassNotFoundException {
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(INSERT_PAGE_ROLE);
		response.setInt(1, pageId);
		response.setInt(2, developerId);
		response.setString(3, Role.getRole(role));
		int result = response.executeUpdate();
		response.close();
		conn.close();
		return result;
	}
	
	public int deleteWebsiteRole(int developerId, int websiteId, int role) throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(DELETE_WEBSITE_ROLE);
		response.setInt(1, developerId);
		response.setInt(2, websiteId);
		response.setString(3, Role.getRole(role));
		int result = response.executeUpdate();
		response.close();
		conn.close();
		return result;
	}
	
	public int deletePageRole(int developerId, int pageId, int role) throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(DELETE_PAGE_ROLE);
		response.setInt(1, developerId);
		response.setInt(2, pageId);
		response.setString(3, Role.getRole(role));
		int result = response.executeUpdate();
		response.close();
		conn.close();
		return result;
	}	
	

}
