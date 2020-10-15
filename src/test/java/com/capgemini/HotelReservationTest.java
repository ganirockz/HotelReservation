package com.capgemini;

import org.junit.*;
import java.util.*;

public class HotelReservationTest {
	@Test
	public void givenHotelsFindTheCheapestHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		Hotel hotel1 = new Hotel("Lakewood", 110,90,3);
		Hotel hotel2 = new Hotel("Bridgewood", 150,50,4);
		Hotel hotel3 = new Hotel("Ridgewood", 220,150,5);
		hotelReservation.hotelReservationSystem.add(hotel1);
		hotelReservation.hotelReservationSystem.add(hotel2);
		hotelReservation.hotelReservationSystem.add(hotel3);
		hotelReservation.findCheapestHotel("11Sep2020,12Sep2020");
	}
}
