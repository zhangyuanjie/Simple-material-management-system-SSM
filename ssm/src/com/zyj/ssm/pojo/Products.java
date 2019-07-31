package com.zyj.ssm.pojo;

public class Products {
	private int id;
	private String name;
	private int bid;
	private int sid;
	private String units;
	private int count;
	private int wvalue;
	private int state;
	private String createtime;
	
	public Products() {
		
	}
	public Products(int id, String name, int bid, int sid, String units, int count, int wvalue, int state,
			String createtime) {
		this.id = id;
		this.name = name;
		this.bid = bid;
		this.sid = sid;
		this.units = units;
		this.count = count;
		this.wvalue = wvalue;
		this.state = state;
		this.createtime = createtime;
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
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getWvalue() {
		return wvalue;
	}
	public void setWvalue(int wvalue) {
		this.wvalue = wvalue;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", bid=" + bid + ", sid=" + sid + ", units=" + units
				+ ", count=" + count + ", wvalue=" + wvalue + ", state=" + state + ", createtime=" + createtime + "]";
	}
	
	
}
