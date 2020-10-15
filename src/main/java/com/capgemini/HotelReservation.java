package com.capgemini;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelReservation {
	static IHotelReservation reservation = (detailsPattern, details) -> {
		Pattern pattern = Pattern.compile(detailsPattern);
		Matcher matcher = pattern.matcher(details);
		return matcher.find();
	};
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Hotel> hotelReservationSystem = new ArrayList<Hotel>();

	public static void main(String[] args) throws InvalidEntryException {
		System.out.println("Welcome to Hotel Reservation");
		System.out.println("Enter the type of customer and date range in <customerType>:<date1>,<date2> format:");
		String customerInput = sc.nextLine();
		String customerTypeAndDate[] = customerInput.split(":");
		String customerType = customerTypeAndDate[0];
		if (!(reservation.validate("[A-Z][a-z]{6}", customerType))) {
			throw new InvalidEntryException("please enter valid customer type");
		}
		Hotel hotel1 = null, hotel2 = null, hotel3 = null;
		if (customerType.equals("Rewards")) {
			hotel1 = new Hotel("Lakewood", 80, 80, 3);
			hotel2 = new Hotel("Bridgewood", 110, 50, 4);
			hotel3 = new Hotel("Ridgewood", 100, 40, 5);
		} else if (customerType.equals("Regular")) {
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
		String dateRange = customerTypeAndDate[1];
		String[] dates = dateRange.split(",");
		int trueCount = 0;
		for (String date : dates) {
			if ((reservation.validate("[0-9]{2}[A-Z][a-z]{2}[0-9]{4}", date))) {
				trueCount++;
			}
		}
		if (trueCount != dates.length) {
			throw new InvalidEntryException("Please enter the valid date range");
		}
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
			hotelReservationSystem.stream().sorted(Comparator.comparing(Hotel::getRating));
			Hotel highRatedHotel = hotelReservationSystem.get(hotelReservationSystem.size() - 1);
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
			System.out.println("The high rated hotel is");
			System.out.println(highRatedHotel.getName() + " & Total Rates:" + hotelPrice);
		} catch (Exception e) {
			System.out.println("cannot parse");
		}
	}

	@SuppressWarnings("deprecation")
	public void findCheapestHighRatedHotel(String dateRange) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		List<Hotel> cheapestHotel = new ArrayList<Hotel>();
		String[] dates = dateRange.split(",");
		Map<Hotel, Integer> priceMap = new HashMap<Hotel, Integer>();
		try {
			int minHotelPrice = Integer.MAX_VALUE;
			for (Hotel hotel : hotelReservationSystem) {
				int hotelPrice = 0;
				for (int i = 0; i < dates.length; i++) {
					Calendar tempDate = Calendar.getInstance();
					tempDate.setTime(dateFormat.parse(dates[i]));
					Date date = tempDate.getTime();
					if ((date.getDay() == 0) || (date.getDay() == 6)) {
						hotelPrice += hotel.getWeekendRate();
					} else {
						hotelPrice += hotel.getWeekdayRate();
					}
					priceMap.put(hotel, hotelPrice);
				}
				if (minHotelPrice > hotelPrice) {
					minHotelPrice = hotelPrice;
				}
			}

			for (Map.Entry<Hotel, Integer> entry : priceMap.entrySet()) {
				if (entry.getValue().equals(minHotelPrice)) {
					cheapestHotel.add(entry.getKey());
				}
			}
			cheapestHotel.stream().sorted(Comparator.comparing(Hotel::getRating));
			System.out.println("The Cheapest hotel with best rating is:");
			System.out.println(cheapestHotel.get(cheapestHotel.size() - 1).getName() + ",Rating:"
					+ cheapestHotel.get(cheapestHotel.size() - 1).getRating() + " and TotalRates: $" + minHotelPrice);
		} catch (Exception e) {
			System.out.println("cannot parse");
		}
	}

}
