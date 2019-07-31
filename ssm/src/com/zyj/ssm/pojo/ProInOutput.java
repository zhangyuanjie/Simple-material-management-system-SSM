package com.zyj.ssm.pojo;

public class ProInOutput {
	private String name;
	private String startTime;
	private String endTime;
	private String annt;
	private String pname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String getAnnt() {
		return annt;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public void setAnnt(String annt) {
		this.annt = annt;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "ProInOutput [name=" + name + ", startTime=" + startTime + ", endTime=" + endTime + ", annt=" + annt
				+ ", pname=" + pname + "]";
	}
	
	
}
