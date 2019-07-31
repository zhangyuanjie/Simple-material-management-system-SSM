package com.zyj.ssm.pojo;

public class Output {
	private int oid;
	private String name;
	private int pcount;
	private double price;
	private String annt;
	private String outputtime;
	
	public Output() {
		
	}
	
	public Output(int oid, String name, int pcount, double price, String annt, String outputtime) {
		this.oid = oid;
		this.name = name;
		this.pcount = pcount;
		this.price = price;
		this.annt = annt;
		this.outputtime = outputtime;
	}

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPcount() {
		return pcount;
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAnnt() {
		return annt;
	}
	public void setAnnt(String annt) {
		this.annt = annt;
	}
	public String getOutputtime() {
		return outputtime;
	}
	public void setOutputtime(String outputtime) {
		this.outputtime = outputtime;
	}
	@Override
	public String toString() {
		return "Output [oid=" + oid + ", name=" + name + ", pcount=" + pcount + ", price=" + price + ", annt=" + annt
				+ ", outputtime=" + outputtime + "]";
	}
	
	
}
