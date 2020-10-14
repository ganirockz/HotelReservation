package com.capgemini;

public class Hotel {
	private String name;
	private int rate;

	public Hotel(String name, int hotelRate) {
		this.name = name;
		rate = hotelRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String toString() {
		return "Hotel Name:" + name + " " + "Rate:" + rate;
	}
}
