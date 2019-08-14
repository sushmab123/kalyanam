package com.ing.matrimony.controller;

import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.matrimony.entity.User;
import com.ing.matrimony.service.SearchService;


@RunWith(SpringJUnit4ClassRunner.class)
public class SearchControllerTest {
	
	@Mock
	SearchService searchService;
	
	@InjectMocks
	SearchController SearchController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(SearchController).build();
	}
	
	
	@Test
	public void test() throws Exception {
    
		List<User> userList=new ArrayList<>();
		User user=new User();
		user.setAddress("BTM");
		user.setAge(23);
		user.setDateOfBirth(LocalDate.now());
		user.setEmail("a@a.com");
		user.setFirstName("shashank");
		user.setGender("Male");
		user.setLastName("kumar");
		user.setMaritalStatus("single");
		user.setMembershipType("classic");
		user.setMobileNo("8970297757");
		user.setMotherTongue("hindi");
		user.setPassword("ok");
		user.setUserId(1L);
		userList.add(user);
		
		Mockito.when(searchService.search(Mockito.anyInt(), Mockito.anyInt(), Mockito.any())).thenReturn(userList);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/search/20/29/male").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(""))).andReturn();

	
	}
public static String asJsonString(final Object obj) {
		
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
