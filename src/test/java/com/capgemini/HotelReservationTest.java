package com.capgemini;
import org.junit.*;
import java.util.*;
public class HotelReservationTest {
	@Test
	public void givenHotelNameAndRateShouldBeAdded() {
		Scanner sc = new Scanner(System.in);
		Hotel hotel = new Hotel("Rosewood",1200);
		Assert.assertEquals("Rosewood", hotel.getName());
	}
}
