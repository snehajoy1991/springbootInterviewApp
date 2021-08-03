package com.springboot.model;



public class Bills {


	private int id;
	
	private int billValue;
	
	public Bills(int id, int billValue) {
		super();
		this.id = id;
		this.billValue = billValue;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBillValue() {
		return billValue;
	}

	public void setBillValue(int billValue) {
		this.billValue = billValue;
	}


}
