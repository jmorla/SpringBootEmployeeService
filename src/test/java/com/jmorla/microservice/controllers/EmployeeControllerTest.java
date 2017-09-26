package com.jmorla.microservice.controllers;

import com.jmorla.microservice.controllers.rest.EmployeeRestController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

	@Autowired private WebApplicationContext context;
	@Autowired private EmployeeRestController employeeController;
	private MockMvc mvc;
	
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(context)
				.build();
	}
	
	@Test
    public void contexLoads() throws Exception {
        assertThat(employeeController).isNotNull();
    }
	
	@Test
	public void shouldReturnEmployeeList() throws Exception{
		String result="[{\"employeeId\":1,\"firstName\":\"Jorge Luis\""
				+ ",\"lastName\":\"Morla Reyes\"}]";
		
		mvc.perform(get("/employees/").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(content().json(result));
	
	}
	
	@Test
	public void shouldReturnEmployeeById() throws Exception{
		String result="{\"employeeId\":1,\"firstName\":\"Jorge Luis\","
				+ "\"lastName\":\"Morla Reyes\"}";
		
		mvc.perform(get("/employees/id/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(content().json(result));
	}
	
	@Test
	public void shouldReturnEmployeeByName() throws Exception{
		String result="{\"employeeId\":1,\"firstName\":\"Jorge Luis\","
				+ "\"lastName\":\"Morla Reyes\"}";
		
		mvc.perform(get("/employees/name/Jorge Luis").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(content().json(result));
	}
	
}
