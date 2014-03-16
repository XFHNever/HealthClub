package edu.nju.healthclub.model;

public class MemberSex {
	private String sex;
	private Long count;
	public MemberSex(String sex, Long count) {
		super();
		this.sex = sex;
		this.count = count;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
}
