package com.capgemini;
import org.junit.*;
import java.util.*;
public class HotelReservationTest {
	@Test
	public void givenHotelNameAndRateShouldBeAdded() {
		Hotel hotel = new Hotel("Rosewood",1200);
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel(hotel);
		Assert.assertEquals(1, hotelReservation.hotelReservationSystem.size());
	}
}
