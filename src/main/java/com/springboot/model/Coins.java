package com.springboot.model;

public class Coins {
		

	private double coinType;
	
	private int noOfCoins;
	
	public Coins(double coinType, int noOfCoins) {
		
	this.coinType =coinType;
	this.noOfCoins =noOfCoins;
	}

	public Coins() {
		// TODO Auto-generated constructor stub
	}

	public double getCoinType() {
		return coinType;
	}

	public void setCoinType(double coinType) {
		this.coinType = coinType;
	}
	
	public int getNoOfCoins() {
		return noOfCoins;
	}	
	public void setNoOfCoins(int noOfCoins) {
		this.noOfCoins = noOfCoins;
	}

	

	

}
