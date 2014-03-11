package edu.nju.healthclub.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.nju.healthclub.service.enuminfo.MEMBER_TYPE;

@Entity
@Table(name="member")
public class Member {
    private int id;
    private String memberid;
    private String name;
    private String password;
    private float balance;
    private String type;
    private String state;
    private String sex;
    private int age;
    private String address;
    private int childnum;
    private int breaktime;
    
    @Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getChildnum() {
		return childnum;
	}
	public void setChildnum(int childnum) {
		this.childnum = childnum;
	}
	public int getBreaktime() {
		return breaktime;
	}
	public void setBreaktime(int breaktime) {
		this.breaktime = breaktime;
	}
  

}
