package com.capgemini;

import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReservation {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Hotel> hotelReservationSystem = new ArrayList<Hotel>();

	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation");
		Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3);
		Hotel hotel2 = new Hotel("Bridgewood", 150, 50, 4);
		Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 5);
		hotelReservationSystem.add(hotel1);
		hotelReservationSystem.add(hotel2);
		hotelReservationSystem.add(hotel3);
		hotelReservationSystem.stream().forEach(System.out::println);
		HotelReservation hotelReservation = new HotelReservation();
		String dateRange = "11Sep2020,12Sep2020";
		hotelReservation.findCheapestHotel(dateRange);
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
	public void findCheapestHotel(String dateRange) {
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
