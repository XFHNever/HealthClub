package edu.nju.healthclub.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="participation")
public class Participation {
    private int id;
    private String participationid;
    private String memberid;
    private String sessionid;
    
    @Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParticipationid() {
		return participationid;
	}
	public void setParticipationid(String participationid) {
		this.participationid = participationid;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	
	//根据memberid和sessionid生成对象id
	public void setParticipationidByAttr() {
		this.participationid = memberid + sessionid;
	}
    
}
