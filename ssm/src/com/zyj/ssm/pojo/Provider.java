package com.zyj.ssm.pojo;

public class Provider {
	private int pid;
	private String pname;
	private String intro;
	
	public Provider() {
		
	}
	public Provider(int pid, String pname, String intro) {
		this.pid = pid;
		this.pname = pname;
		this.intro = intro;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	@Override
	public String toString() {
		return "Provider [pid=" + pid + ", pname=" + pname + ", intro=" + intro + "]";
	}
	
}
