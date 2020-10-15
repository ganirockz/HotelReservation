package com.capgemini;
import org.junit.*;
import java.util.*;
public class HotelReservationTest {
	@Test
	public void givenHotelNameAndRateShouldBeAdded() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel();
		Assert.assertEquals(1, hotelReservation.hotelReservationSystem.size());
	}
}
