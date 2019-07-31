package com.zyj.ssm.pojo;

import org.springframework.stereotype.Repository;

@Repository("admin")
public class Admin {
	
	private String name;
	private String pwd;
	private int id;
	private int state;
	private int count;
	private String time;
	
	public Admin(){
		
	}
	
	public Admin(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("±ªªÿ ’");
		super.finalize();
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", pwd=" + pwd + ", id=" + id + ", state=" + state + ", count=" + count
				+ ", time=" + time + "]";
	}

	
}
