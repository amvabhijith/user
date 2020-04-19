package com.altran.user.controller;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;



	@Test
	void testGetUserDetails() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getUserDetails/yds").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.userName").exists())
		.andExpect(jsonPath("$.userName").exists())
		.andExpect(jsonPath("$.password").exists())
		.andExpect(jsonPath("$.firstName").exists())
		.andExpect(jsonPath("$.lastName").exists())
		.andExpect(jsonPath("$.userName").value("yds"))
		.andExpect(jsonPath("$.password").value("12345"))
		.andExpect(jsonPath("$.firstName").value("Yagya"))
		.andExpect(jsonPath("$.lastName").value("DS"))
		.andDo(print());
	}



	@Test 
	public void verifyRegistration() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/registration/")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"firstName\":\"vikhil\",\r\n" + "\"lastName\":\"k\",\r\n" +
						"\"userName\":\"vikhilk\",\r\n" + "\"password\":\"12345\",\r\n" +
						"\"passwordConfirm\":\"12345\"}") .accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.firstName").exists())
		.andExpect(jsonPath("$.lastName").exists())
		.andExpect(jsonPath("$.userName").exists())
		.andExpect(jsonPath("$.password").exists())
		.andExpect(jsonPath("$.passwordConfirm").exists())
		.andExpect(jsonPath("$.firstName").value("vikhil"))
		.andExpect(jsonPath("$.lastName").value("k"))
		.andExpect(jsonPath("$.userName").value("vikhilk"))
		.andExpect(jsonPath("$.password").value("12345"))
		.andExpect(jsonPath("$.passwordConfirm").value("12345")) .andDo(print()); 
	}


}
