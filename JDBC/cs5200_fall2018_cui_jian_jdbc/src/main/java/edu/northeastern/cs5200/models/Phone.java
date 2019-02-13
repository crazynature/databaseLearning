package edu.northeastern.cs5200.models;

public class Phone {
	private String phone;
	private boolean primary;
	
	public Phone(String phone, boolean primary) {
		this.phone = phone;
		this.primary = primary;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean getPrimary() {
		return primary;
	}
	
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

}
