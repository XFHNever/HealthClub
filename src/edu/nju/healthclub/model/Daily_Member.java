package edu.nju.healthclub.model;

import java.util.Date;

public class Daily_Member {
	private Date date;
	private Long count;



	public Daily_Member(Date date, Long count) {
		this.date = date;
		this.count = count;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
