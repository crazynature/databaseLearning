package edu.northeastern.cs5200.daos;
import edu.northeastern.cs5200.models.Website;
import java.sql.SQLException;
import java.util.Collection;
public interface Websitelmpl {

	public void createWebsiteForDeveloper(int developerId, Website website)  throws SQLException, ClassNotFoundException; 
	public Collection<Website> findAllWebsites() throws SQLException, ClassNotFoundException;
	public Collection<Website> findWebsitesForDeveloper(int developerId)throws SQLException, ClassNotFoundException;
	public Website findWebsiteById(int websiteId) throws SQLException, ClassNotFoundException;
	public int updateWebsite(int websiteId, Website website) throws SQLException, ClassNotFoundException;
	public int deleteWebsite(int websiteId) throws SQLException, ClassNotFoundException;
}
