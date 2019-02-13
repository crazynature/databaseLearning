package edu.northeastern.cs5200.daos;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Priviledge;

public class PriviledgeDao {
	public static PriviledgeDao instance = null;
	public static PriviledgeDao getInstance() {
		if (instance == null) {
			instance = new PriviledgeDao();
		}
		return instance;
	}
	private final String INSERT_WEBSITE_PRIVILEDGE = "INSERT Into website_priviledge (website_id, developer_id, priviledge) VALUES (?,?,?)";
	private final String INSERT_PAGE_PRIVILEDGE = "INSERT Into page_priviledge (page_id, developer_id, priviledge)  VALUES (?,?,?)";
	private final String DELETE_WEBIST_PRIVILEDGE = "DELETE FROM website_priviledge WHERE developer_id=? AND website_id=? AND priviledge=?";
	private final String DELETE_PAGE_PRIVILEDGE = "DELETE FROM page_priviledge WHERE developer_id=? AND page_id=? AND priviledge=?";

	
	public int assignWebsitePrivilege(int developerId, int websiteId, Priviledge priviledge) throws SQLException, ClassNotFoundException {
		
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(INSERT_WEBSITE_PRIVILEDGE);
		response.setInt(1, websiteId);
		response.setInt(2, developerId);
		response.setString(3, priviledge.toString());
		int result = response.executeUpdate();
		response.close();
		conn.close();
		return result;
	}
	
	public int assignPagePrivilege(int developerId, int pageId, Priviledge priviledge) throws SQLException, ClassNotFoundException {
		
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(INSERT_PAGE_PRIVILEDGE);
		response.setInt(1, pageId);
		response.setInt(2, developerId);
		response.setString(3, priviledge.toString());
		int result = response.executeUpdate();
		response.close();
		conn.close();
		return result;
	}
	
	public int deleteWebsitePrivilege(int developerId, int websiteId, Priviledge priviledge) throws ClassNotFoundException, SQLException {
		
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(DELETE_WEBIST_PRIVILEDGE);
		response.setInt(1, developerId);
		response.setInt(2, websiteId);
		response.setString(3, priviledge.toString());
		int result = response.executeUpdate();
		response.close();
		conn.close();
		return result;
	}
	
	public int deletePagePrivilege(int developerId, int pageId, Priviledge priviledge) throws ClassNotFoundException, SQLException {
		
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(DELETE_PAGE_PRIVILEDGE);
		response.setInt(1, developerId);
		response.setInt(2, pageId);
		response.setString(3, priviledge.toString());
		int result = response.executeUpdate();
		response.close();
		conn.close();
		return result;
	}	
}
