package edu.nju.healthclub.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="waiter")
public class Waiter {
    private int id;
    private String waiterid;
    private String name;
    private String password;
    
    @Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWaiterid() {
		return waiterid;
	}
	public void setWaiterid(String waiterid) {
		this.waiterid = waiterid;
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
    
}
