package edu.northeastern.cs5200.models;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;


public class Website {
	private int id;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private int visits;
	private Collection<Page> pages;
	private Developer developer;
	private int developerId;
	
	public Website() {
	}
	

	public Website(int id, String name, 
			String description, Date created, 
			Date updated, int visits) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.pages = new ArrayList<Page>();
	}	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public Date getUpdated() {
		return updated;
	}
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public int getVisits() {
		return visits;
	}
	
	public void setVisits(int visits) {
		this.visits = visits;
	}

	public Collection<Page> getPages(){
		return pages;
	}
	
	public void addPages(Page page) {
		this.pages.add(page);
	}
	
	public void removePages(Page page) {
		this.pages.remove(page);
	}
	
	public void setPages(Collection<Page> pages) {
		this.pages = pages;
	}
	
	public Developer getDeveloper() {
		return developer;
	}
	
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	
	public int getDeveloperId() {
		return developerId;
	}
	
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
}
