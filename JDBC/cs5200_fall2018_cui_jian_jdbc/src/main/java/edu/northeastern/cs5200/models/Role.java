package edu.northeastern.cs5200.models;

public class Role {
	
	private static String[] role = {"owner","editor","admin","writer","reviewer"}; 
	public static String getRole(int index) {
		return role[index];
	}
}
