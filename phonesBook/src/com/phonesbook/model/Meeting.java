package com.phonesbook.model;

import java.util.Date;

public class Meeting extends Compromise{
	private Date endTime;

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
