package com.ing.matrimony.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.matrimony.dto.ProfileResponseDto;
import com.ing.matrimony.entity.User;
import com.ing.matrimony.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileServiceImplTest {

	@InjectMocks
	ProfileServiceimpl profileServiceImpl;

	@Mock
	UserRepository userRepository;

	@Test
	public void testFindUserById() {
		User user = new User();
		user.setFirstName("Chandu");
		user.setUserId(1L);
		when(userRepository.findByUserId(1L)).thenReturn(user);
		ProfileResponseDto profileResponseDto = profileServiceImpl.showProfile(1L);
		Assert.assertEquals(user.getFirstName(), profileResponseDto.getFirstName());
	}
}
