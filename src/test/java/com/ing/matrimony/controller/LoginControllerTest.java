package com.ing.matrimony.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.matrimony.dto.LoginDto;
import com.ing.matrimony.dto.LoginResponseDto;
import com.ing.matrimony.entity.User;
import com.ing.matrimony.service.LoginService;



@RunWith(SpringJUnit4ClassRunner.class)
public class LoginControllerTest {

	
	private MockMvc mockMvc;
	
	@MockBean
	LoginService loginService;

	@InjectMocks
	LoginController loginController;
	
	User user;
	LoginDto loginDto;
	LoginResponseDto loginResponseDto;

	@Before
	public void setUp() {

	
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
 	public void loginTest() throws Exception {
		
		LoginDto loginDto=new LoginDto();
		loginDto.setMobileNo("8970297757");
		loginDto.setPassword("ok");
		Mockito.when(loginService.login(loginDto)).thenReturn(loginResponseDto);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/login").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(loginDto))).andReturn();
		
		
		
		ResponseEntity<LoginResponseDto> loginResponseDto=loginController.login(loginDto);
		assertEquals("Logged in Successfully", loginResponseDto.getBody().getMessage());
	}

}
