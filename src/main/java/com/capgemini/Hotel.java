package com.capgemini;

public class Hotel {
	private String name;
	private int weekdayRate;
	private int weekendRate;
	private int rating;

	public Hotel(String name, int weekdayRate, int weekendRate,int rating) {
		this.name = name;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeekdayRate() {
		return weekdayRate;
	}

	public void setWeekdayRate(int weekdayRate) {
		this.weekdayRate = weekdayRate;
	}

	public int getWeekendRate() {
		return weekendRate;
	}

	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}

	@Override
	public String toString() {
		return "Hotel Name:" + name + " " + "WeekdayRate:" + weekdayRate + " weekendRate:" + weekendRate+" Rating:"+rating;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
