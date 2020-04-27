package com.altran.user.service;

import com.altran.user.model.Flight;
import com.altran.user.model.Flights;
import com.altran.user.model.User;
import com.altran.user.repository.FlightRepository;
import com.altran.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

/**
 * Created by 4013707 on 4/17/2020.
 */
public class UserServiceTest {


    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
	FlightRepository flightRepository;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void testGetUserDetails() {
    	User user = new User(1, "amvabhijith", "pass123","pass123","abhijith","am");
    	when(userRepository.findByUserName("amvabhijith")).thenReturn(user);
    	
    	User result = userService.getUserDetails("amvabhijith");
		assertEquals(1, result.getUserId());
		assertEquals("amvabhijith", result.getUserName());
		assertEquals("pass123", result.getPassword());
		assertEquals("pass123", result.getPasswordConfirm());
		assertEquals("abhijith", result.getFirstName());
		assertEquals("am", result.getLastName());
    }

    @Test
    void testRegistration() {
    	User user = new User(1, "amvabhijith", "pass123","pass123","abhijith","am");
    	when(userRepository.save(user)).thenReturn(user);
    	
    	User result = userService.registration(user);
		assertEquals(1, result.getUserId());
		assertEquals("amvabhijith", result.getUserName());
		assertEquals("pass123", result.getPassword());
		assertEquals("pass123", result.getPasswordConfirm());
		assertEquals("abhijith", result.getFirstName());
		assertEquals("am", result.getLastName());
    }


	@Nested
	@DisplayName("Test method for getting flight details by departure time")
	class FlightByDepartureTimeTest{

		@Test
		@DisplayName("Test getFlightByDepartureTime weekdays")
		void getFlightByDepartureTimeWeekday() throws ParseException {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
			List<Flight> flightList = Arrays.asList(
					new Flight(1, formatter.parse("2020-04-23 14:30:00"),formatter.parse("2020-04-23 12:30:00"),"go air flight","delhi","g8-120",5630,180,"bangalore"),
					new Flight(2, formatter.parse("2020-04-23 14:30:00"),formatter.parse("2020-04-23 12:40:00"),"go air flight","delhi","g8-119",5430,180,"kochi"));
			Date departureTimeStart = formatter.parse("2020-04-23 00:00:00");

			when(flightRepository.findByDepartureTimeBetween(eq(departureTimeStart),any(Date.class))).thenReturn(flightList);

			Flights flights = userService.getFlightByDepartureTime(departureTimeStart);

			assertAll(
					()-> assertNotNull(flights.getFlights()),
					()-> assertEquals(2,flights.getFlights().size()),
					()-> assertAll(
							()->flights.getFlights().parallelStream().forEach(k ->
							{
								LocalDate localDate = k.getDepartureTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
								assertEquals(localDate.getDayOfMonth(),23);
								assertEquals(localDate.getMonthValue(),04);
								assertEquals(localDate.getYear(),2020);
								if(k.getNumber().equals("g8-120")){
									assertEquals(k.getPrice() , 5630);
								} else if(k.getNumber().equals("g8-119")){
									assertEquals(k.getPrice() , 5430);
								}
							})
					)
			);
		}

		@Test
		@DisplayName("Test getFlightByDepartureTime Negative")
		void getFlightByDepartureTimeNegative() throws ParseException {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
			List<Flight>  flightList = Arrays.asList(
					new Flight(1, formatter.parse("2020-04-25 14:30:00"),formatter.parse("2020-04-25 12:30:00"),"go air flight","delhi","g8-120",5630,180,"bangalore"),
					new Flight(2, formatter.parse("2020-04-25 14:30:00"),formatter.parse("2020-04-25 12:40:00"),"go air flight","delhi","g8-119",5430,180,"kochi"));
			Date departureTimeStart = formatter.parse("24-04-2020 00:00:00");

			when(flightRepository.findByDepartureTimeBetween(eq(formatter.parse("2020-04-25 14:30:00")),any(Date.class))).thenReturn(flightList);

			Flights flights = userService.getFlightByDepartureTime(departureTimeStart);

			assertAll(
					()-> assertNotNull(flights.getFlights()),
					()-> assertEquals(0,flights.getFlights().size())
			);
		}

		@Test
		@DisplayName("Test getFlightByDepartureTime Positive")
		void getFlightByDepartureTimePositive() throws ParseException {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
			List<Flight>  flightList = Arrays.asList(
					new Flight(1, formatter.parse("2020-04-25 14:30:00"),formatter.parse("2020-04-25 12:30:00"),"go air flight","delhi","g8-120",5630,180,"bangalore"),
					new Flight(2, formatter.parse("2020-04-25 14:30:00"),formatter.parse("2020-04-25 12:40:00"),"go air flight","delhi","g8-119",5430,180,"kochi"));
			Date departureTimeStart = formatter.parse("2020-04-25 00:00:00");

			when(flightRepository.findByDepartureTimeBetween(eq(departureTimeStart),any(Date.class))).thenReturn(flightList);

			Flights flights = userService.getFlightByDepartureTime(departureTimeStart);

			assertAll(
					()-> assertNotNull(flights.getFlights()),
					()-> assertEquals(2,flights.getFlights().size()),
					()-> assertAll(
							()->flights.getFlights().parallelStream().forEach(k ->
							{
								LocalDate localDate = k.getDepartureTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
								assertEquals(localDate.getDayOfMonth(),25);
								assertEquals(localDate.getMonthValue(),04);
								assertEquals(localDate.getYear(),2020);
								if(k.getNumber().equals("g8-120")){
									assertEquals(k.getPrice() , 5630*2);
								} else if(k.getNumber().equals("g8-119")){
									assertEquals(k.getPrice() , 5430*2);
								}
							})
					)
			);
		}
	}

}