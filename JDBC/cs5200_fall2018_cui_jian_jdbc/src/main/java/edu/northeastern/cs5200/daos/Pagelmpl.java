package edu.northeastern.cs5200.daos;

import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.models.Page;

public interface Pagelmpl {

	public void createPageForWebsite(int websiteId, Page page)throws SQLException, ClassNotFoundException;
	public Collection<Page> findAllPages()throws SQLException, ClassNotFoundException;
	public Page findPageById(int pageId)throws SQLException, ClassNotFoundException;
	public Collection<Page> findPagesForWebsite(int websiteId)throws SQLException, ClassNotFoundException;
	public int updatePage(int pageId, Page page)throws SQLException, ClassNotFoundException;
	public int deletePage(int pageId)throws SQLException, ClassNotFoundException;
}
