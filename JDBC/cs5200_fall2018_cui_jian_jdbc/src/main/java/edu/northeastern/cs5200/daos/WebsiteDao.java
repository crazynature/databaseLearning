package edu.northeastern.cs5200.daos;




import edu.northeastern.cs5200.models.Role;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class WebsiteDao implements Websitelmpl{

	public static WebsiteDao instance = null;
	public static WebsiteDao getInstance() {
		if (instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}
	private final String INSERT_WEBSITE="INSERT INTO website (id, developer_id, name, description, visits) VALUES (?,?,?,?,?)";
	private final String FIND_ALL_WEBSITE= "SELECT * FROM website";
	private final String FIND_ALLWEBSITE_BY_DEVELOPER="SELECT * FROM website WHERE developer_id = ";
	private final String FIND_ALLWEBSITE_BY_ID = "SELECT * FROM website WHERE website.id = ";
	private final String UPDATE_WEBSITE = "UPDATE website SET developer_id = ?, name = ?, description = ?, visits = ? WHERE website.id = ?";
	private final String DELETE_WEBSITE = "DELETE FROM website WHERE website.id = ";
	
	public void createWebsiteForDeveloper(int developerId, Website website) throws SQLException, ClassNotFoundException {
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(INSERT_WEBSITE);
		response.setInt(1, website.getId());
		response.setInt(2, developerId);
		response.setString(3, website.getName());
		response.setString(4, website.getDescription());
		response.setInt(5, website.getVisits());
		response.executeUpdate();
		response.close();
		conn.close();
	}
	
	public Collection<Website> findAllWebsites() throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		Collection<Website> websites = new ArrayList<Website>();
		ResultSet result = response.executeQuery(FIND_ALL_WEBSITE);
		while (result.next()) {
			Website website = new Website(result.getInt("id"),
					result.getString("name"),
					result.getString("description"),
					result.getDate("created"),
					result.getDate("updated"),
					result.getInt("visits"));
			websites.add(website);
		}
		
		response.close();
		conn.close();
		return websites;
	}
	
	public Collection<Website> findWebsitesForDeveloper(int developerId) throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		Collection<Website> websites = new ArrayList<Website>();
		ResultSet result = response.executeQuery(FIND_ALLWEBSITE_BY_DEVELOPER+String.valueOf(developerId));
		while (result.next()) {
			Website website = new Website(result.getInt("id"),
					result.getString("name"),
					result.getString("description"),
					result.getDate("created"),
					result.getDate("updated"),
					result.getInt("visits"));
			website.setDeveloperId(result.getInt("developer_id"));
			websites.add(website);
		}
		
		response.close();
		conn.close();
		return websites;
	}
	
	public Website findWebsiteById(int websiteId) throws ClassNotFoundException, SQLException {

		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		ResultSet result = response.executeQuery(FIND_ALLWEBSITE_BY_ID+String.valueOf(websiteId));
		Website website = null;
		if (result.next()) {
			website = new Website(result.getInt("id"),
					result.getString("name"),
					result.getString("description"),
					result.getDate("created"),
					result.getDate("updated"),
					result.getInt("visits"));
			website.setDeveloperId(result.getInt("developer_id"));
		}
		
		response.close();
		conn.close();
		return website;
	}

	public int updateWebsite(int websiteId, Website website) throws SQLException, ClassNotFoundException {
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(UPDATE_WEBSITE);
		response.setInt(1, website.getDeveloperId());
		response.setString(2, website.getName());
		response.setString(3, website.getDescription());
		response.setInt(4, website.getVisits());
		response.setInt(5, websiteId);
		int result = response.executeUpdate();
		response.close();
		conn.close();
		return result;	
	}
	
	public int deleteWebsite(int websiteId) throws SQLException, ClassNotFoundException {

		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		int result = response.executeUpdate(DELETE_WEBSITE+String.valueOf(websiteId));
		response.close();
		conn.close();
		return result;
		
	}


}

