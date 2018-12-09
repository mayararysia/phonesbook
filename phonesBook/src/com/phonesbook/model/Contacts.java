package com.phonesbook.model;

import java.util.Date;

public class Contacts {
	private int id;
	private String name;
	private String email_address;
	private String phone_number;
	private String mobile_number;
	private Boolean is_favorite;	
	
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
	
	public String getEmail_address() {
		return email_address;
	}
	
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public String getMobile_number() {
		return mobile_number;
	}
	
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	public Boolean getIs_favorite() {
		return is_favorite;
	}
	
	public void setIs_favorite(Boolean is_favorite) {
		this.is_favorite = is_favorite;
	}
}
