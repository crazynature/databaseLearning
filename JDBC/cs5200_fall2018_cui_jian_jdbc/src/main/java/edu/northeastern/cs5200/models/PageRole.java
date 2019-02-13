package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageRole {

	private Map<Integer,Integer> role;
	private int pageId;
	
	public PageRole(int pageId) {
		this.pageId = pageId;
		this.role = new HashMap();
	}
	public PageRole(int pageId,Map<Integer,Integer>  role) {
		this.role = role;
		this.pageId = pageId;
	}
	
	public int getPageId() {
		return pageId;
	}
	
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	
	public void setPageRole(int personId,int role) {
		this.role.put(personId,role);
	}
	public Map<Integer,Integer> getPageRole(){
		return role;
	}
	

}
