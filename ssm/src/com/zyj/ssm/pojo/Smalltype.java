package com.zyj.ssm.pojo;

public class Smalltype {
	private int id;
	private String name;
	private int bid;
	private int state;
	public Smalltype() {
	
	}
	public Smalltype(int id, String name, int bid, int state) {
		this.id = id;
		this.name = name;
		this.bid = bid;
		this.state = state;
	}
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
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Smalltype [id=" + id + ", name=" + name + ", bid=" + bid + ", state=" + state + "]";
	}
	
}
