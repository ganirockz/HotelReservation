package com.capgemini;

import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReservation {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Hotel> hotelReservationSystem = new ArrayList<Hotel>();
	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation");
		Hotel hotel1 = new Hotel("Lakewood", 110);
		Hotel hotel2  = new Hotel("Bridgewood",160);
		Hotel hotel3 = new Hotel("Ridgewood",220);
		hotelReservationSystem.add(hotel1);
		hotelReservationSystem.add(hotel2);
		hotelReservationSystem.add(hotel3);
		HotelReservation hotelReservation = new HotelReservation();
		//hotelReservation.addHotel();
		System.out.println(hotelReservationSystem);
		Hotel cheapestHotel = hotelReservation.findCheapestHotel();
		System.out.println(cheapestHotel);
	}
	public void addHotel() {
		System.out.println("Enter the name of the new hotel");
		String hotelName = sc.nextLine();
		System.out.println("Enter the rate of the hotel");
		int hotelRate = Integer.parseInt(sc.nextLine());
		Hotel hotel = new Hotel(hotelName,hotelRate);
		hotelReservationSystem.add(hotel);
	}
	public Hotel findCheapestHotel() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		Hotel cheapestHotel = null;
		try {
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			System.out.println("Enter the start date like 12Jan2020");
			String startDate = sc.nextLine();
			System.out.println("Enter the end date like 12Jan2020");
			String endDate = sc.nextLine();
			start.setTime(dateFormat.parse(startDate));
			end.setTime(dateFormat.parse(endDate));
			int minPrice = Integer.MAX_VALUE;
			for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
			    for(Hotel hotel:hotelReservationSystem) {
			    	if(hotel.getRate() < minPrice) {
			    		minPrice = hotel.getRate();
			    		cheapestHotel= hotel;
			    	}
			    }
			}
		}
		catch(Exception e) {
			System.out.println("cannot parse");
		}
		return cheapestHotel;
	}
}
