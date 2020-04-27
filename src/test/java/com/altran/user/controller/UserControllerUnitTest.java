package com.altran.user.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.altran.user.model.Flight;
import com.altran.user.model.Flights;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.altran.user.model.User;
import com.altran.user.repository.UserRepository;
import com.altran.user.service.UserService;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
class UserControllerUnitTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	@Mock
	UserRepository userRepository;


	@Test 
	void testRegistration() { 
		MockHttpServletRequest request = new MockHttpServletRequest(); 
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

//		when(userService.registration(any(User.class))).thenReturn(true);
		
		User user1 = new User();
		when(userService.registration(any(User.class))).thenReturn(user1);

		User user = new User(1, "amvabhijith", "pass123","pass123","abhijith","am");
		ResponseEntity<User> responseEntity = userController.registration(user);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}


	@Test 
	void testGetUserDetails() {
		User user = new User(1, "amvabhijith","pass123","pass123","abhijith","am");

		when(userService.getUserDetails("amvabhijith")).thenReturn(user);
		
		// when
		ResponseEntity<User> result = userController.getUserDetails("amvabhijith");

		// then 
		assertEquals(result.getBody().getUserName(),user.getUserName());

		assertEquals(result.getBody().getPassword(), user.getPassword());

		assertEquals(result.getBody().getFirstName(),user.getFirstName());

		assertEquals(result.getBody().getLastName(),user.getLastName());



	}

    /*@Test
    void getAllFlights() {
    }*/


    /*@Test
    void getFlightByDepartureTimeForException(){
        Throwable exception = assertThrows(
                ParseException.class, () -> {
                    List<Flight> flightList = new ArrayList<>();
                    flightList.setName(null);
                }
        );

    }*/

	@Test
	void getFlightByDepartureTime() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		List<Flight> flightList = Arrays.asList(
				new Flight(1, formatter.parse("2020-04-25 14:30:00"),formatter.parse("2020-04-25 12:30:00"),"go air flight","delhi","g8-120",11260,180,"kochi"),
				new Flight(2, formatter.parse("2020-04-25 14:40:00"),formatter.parse("2020-04-25 12:40:00"),"go air flight","delhi","g8-119",10860,180,"bangalore"));
		Date departureTimeStart = formatter.parse("2020-04-25 00:00:00");
		Flights flights = new Flights(flightList);

		when(userService.getFlightByDepartureTime(departureTimeStart)).thenReturn(flights);

		// when
		Flights flights1 = userController.getFlightByDepartureTime(departureTimeStart);

		// then
		assertAll(
				()-> assertNotNull(flights1.getFlights()),
				()-> assertEquals(2,flights1.getFlights().size()),
				()-> assertAll(
						()->flights.getFlights().parallelStream().forEach(k ->
						{
							LocalDate localDate = k.getDepartureTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
							assertTrue(localDate.getDayOfMonth()==25);
							assertTrue(localDate.getMonthValue()==04);
							assertTrue(localDate.getYear()==2020);
							if(k.getNumber().equals("g8-120")){
								assertTrue(k.getPrice() == 5630*2);
							} else if(k.getNumber().equals("g8-119")){
								assertTrue(k.getPrice() == 5430*2);
							}
						})
				)
		);
	}


}
