package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Page;

public class PageDao implements Pagelmpl{
	
	public static PageDao instance = null;
	public static PageDao getInstance() {
		if (instance == null) {
			instance = new PageDao();
		}
		return instance;
	}
	private final String INSERT_PAGE = "INSERT INTO page (id, website_id, title, description, views) VALUES (?,?,?,?,?)";
	private final String FIND_ALL_PAGE = "SELECT * FROM page";
	private final String FIND_PAGE_BY_ID = "SELECT * FROM page WHERE page.id = ";
	private final String FIND_PAGE_BY_WEBSITE_ID = "SELECT * FROM page WHERE website_id = ";
	private final String DELETE_PAGE = "DELETE FROM page WHERE page.id = ";
	private final String UPDATE_PAGE = "UPDATE page SET website_id = ?, title = ?, description = ?, views = ? WHERE page.id = ?";
	
	public void createPageForWebsite(int websiteId, Page page) throws SQLException, ClassNotFoundException {
		java.sql.Connection conn = Connection.getConnection();		
		PreparedStatement response = conn.prepareStatement(INSERT_PAGE);
		response.setInt(1, page.getId());
		response.setInt(2, websiteId);
		response.setString(3, page.getTitle());
		response.setString(4, page.getDescription());
		response.setInt(5, page.getViews());
		response.executeUpdate();
		response.close();
		conn.close();

	}
	
	public Collection<Page> findAllPages() throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		Collection<Page> pages = new ArrayList<Page>();
		ResultSet result = response.executeQuery(FIND_ALL_PAGE);
		while (result.next()) {
			Page page = new Page(result.getInt("id"),
					result.getString("title"),
					result.getString("description"),
					result.getDate("created"),
					result.getDate("updated"),
					result.getInt("views"));
			page.setWebsiteId(result.getInt("website_id"));
			pages.add(page);
		}
		
		response.close();
		conn.close();
		return pages;
	}
	
	public Page findPageById(int pageId) throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		ResultSet result = response.executeQuery(FIND_PAGE_BY_ID+String.valueOf(pageId));
		Page page = null;
		if (result.next()) {
			page = new Page(result.getInt("id"),
					result.getString("title"),
					result.getString("description"),
					result.getDate("created"),
					result.getDate("updated"),
					result.getInt("views"));
			page.setWebsiteId(result.getInt("website_id"));
		}
		response.close();
		conn.close();
		return page;
	}

	public Collection<Page> findPagesForWebsite(int websiteId) throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		ResultSet result = response.executeQuery(FIND_PAGE_BY_WEBSITE_ID+String.valueOf(websiteId));
		Collection<Page> pages = new ArrayList<Page>();
		while (result.next()) {
			Page page = new Page(result.getInt("id"),
					result.getString("title"),
					result.getString("description"),
					result.getDate("created"),
					result.getDate("updated"),
					result.getInt("views"));
			page.setWebsiteId(result.getInt("website_id"));
			pages.add(page);
		}
		response.close();
		conn.close();
		return pages;
	}

	
	public int updatePage(int pageId, Page page) throws SQLException, ClassNotFoundException {
		java.sql.Connection conn = Connection.getConnection();
		PreparedStatement response = conn.prepareStatement(UPDATE_PAGE);
		response.setInt(1, page.getWebsiteId());
		response.setString(2, page.getTitle());
		response.setString(3, page.getDescription());
		response.setInt(4, page.getViews());
		response.setInt(5, pageId);
		int result = response.executeUpdate();
		response.close();
		conn.close();
		return result;	
	}
	
	public int deletePage(int pageId) throws SQLException, ClassNotFoundException {
		java.sql.Connection conn = Connection.getConnection();
		Statement response = conn.createStatement();
		int result = response.executeUpdate(DELETE_PAGE+String.valueOf(pageId));
		response.close();
		conn.close();
		return result;
		
	}
	

}
