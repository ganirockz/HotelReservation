package com.capgemini;

import java.util.*;

public class HotelReservation {
	static ArrayList<Hotel> hotelReservationSystem = new ArrayList<Hotel>();
	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation");
		Hotel hotel = new Hotel("Rosewood", 1200);
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel(hotel);
		System.out.println(hotelReservationSystem);
	}
	public void addHotel(Hotel hotel) {
		hotelReservationSystem.add(hotel);
	}
}
