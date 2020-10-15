package com.capgemini;

import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReservation {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Hotel> hotelReservationSystem = new ArrayList<Hotel>();

	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation");
		System.out.println("Enter the type of customer:");
		String customerType = sc.nextLine();
		Hotel hotel1 = null, hotel2 = null, hotel3 = null;
		if (customerType.toLowerCase().equals("rewards")) {
			hotel1 = new Hotel("Lakewood", 80, 80, 3);
			hotel2 = new Hotel("Bridgewood", 110, 50, 4);
			hotel3 = new Hotel("Ridgewood", 100, 40, 5);
		} else {
			hotel1 = new Hotel("Lakewood", 110, 90, 3);
			hotel2 = new Hotel("Bridgewood", 150, 50, 4);
			hotel3 = new Hotel("Ridgewood", 220, 150, 5);
		}
		hotelReservationSystem.add(hotel1);
		hotelReservationSystem.add(hotel2);
		hotelReservationSystem.add(hotel3);
		System.out.println("The Hotels in the city are");
		hotelReservationSystem.stream().forEach(System.out::println);
		HotelReservation hotelReservation = new HotelReservation();
		System.out.println("Enter the range of dates to select best rated hotel");
		String dateRange = sc.nextLine();
		hotelReservation.findHighRatedHotel(dateRange);
	}

	public void addHotel() {
		System.out.println("Enter the name of the new hotel");
		String hotelName = sc.nextLine();
		System.out.println("Enter the weekDay rate of the hotel");
		int weekDayRate = Integer.parseInt(sc.nextLine());
		System.out.println("Enter the weekEnd rate of the hotel");
		int weekEndRate = Integer.parseInt(sc.nextLine());
		System.out.println("Enter the rating of hotel");
		int rating = Integer.parseInt(sc.nextLine());
		Hotel hotel = new Hotel(hotelName, weekDayRate, weekEndRate, rating);
		hotelReservationSystem.add(hotel);
	}

	@SuppressWarnings("deprecation")
	public void findHighRatedHotel(String dateRange) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		String[] dates = dateRange.split(",");
		try {
			int hotelRating = 0;
			Hotel highRatedHotel = null;
			for (Hotel hotel : hotelReservationSystem) {
				if (hotel.getRating() > hotelRating) {
					highRatedHotel = hotel;
					hotelRating = hotel.getRating();
				}
			}
			int hotelPrice = 0;
			for (int i = 0; i < dates.length; i++) {
				Calendar tempDate = Calendar.getInstance();
				tempDate.setTime(dateFormat.parse(dates[i]));
				Date date = tempDate.getTime();
				if ((date.getDay() == 0) || (date.getDay() == 6)) {
					hotelPrice += highRatedHotel.getWeekendRate();
				} else {
					hotelPrice += highRatedHotel.getWeekdayRate();
				}
			}
			System.out.println(highRatedHotel.getName() + " & Total Rates:" + hotelPrice);
		} catch (Exception e) {
			System.out.println("cannot parse");
		}
	}
}
