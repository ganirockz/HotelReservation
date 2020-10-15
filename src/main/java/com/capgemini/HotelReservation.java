package com.capgemini;

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
		hotelReservation.addHotel();
		System.out.println(hotelReservationSystem);
	}
	public void addHotel() {
		System.out.println("Enter the name of the new hotel");
		String hotelName = sc.nextLine();
		System.out.println("Enter the rate of the hotel");
		int hotelRate = Integer.parseInt(sc.nextLine());
		Hotel hotel = new Hotel(hotelName,hotelRate);
		hotelReservationSystem.add(hotel);
	}
}
