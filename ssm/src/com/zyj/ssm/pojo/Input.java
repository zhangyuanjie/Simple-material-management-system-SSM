package com.zyj.ssm.pojo;

public class Input {
	private int id;
	private String name;
	private int pcount;
	private double dprice;
	private double price;
	private String annt;
	private String pname;
	private String inputtime;

	public Input() {
		
	}
	
	public Input(int id, String name, int pcount, double dprice, double price, String annt, String pname,
			String inputtime) {
		this.id = id;
		this.name = name;
		this.pcount = pcount;
		this.dprice = dprice;
		this.price = price;
		this.annt = annt;
		this.pname = pname;
		this.inputtime = inputtime;
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

	public int getPcount() {
		return pcount;
	}

	public void setPcount(int pcount) {
		this.pcount = pcount;
	}

	public double getDprice() {
		return dprice;
	}

	public void setDprice(double dprice) {
		this.dprice = dprice;
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

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getInputtime() {
		return inputtime;
	}

	public void setInputtime(String inputtime) {
		this.inputtime = inputtime;
	}
	

	@Override
	public String toString() {
		return "Input [id=" + id + ", name=" + name + ", pcount=" + pcount + ", dprice=" + dprice + ", price=" + price
				+ ", annt=" + annt + ", pname=" + pname + ", inputtime=" + inputtime + "]";
	}


}
