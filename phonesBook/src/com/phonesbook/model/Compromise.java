package com.phonesbook.model;

import java.util.Date;

public class Compromise {
	private Integer id;
	private String title;
	private String type;
	private String desc;//description
	private Date date;
	private Date time;
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
	

}
