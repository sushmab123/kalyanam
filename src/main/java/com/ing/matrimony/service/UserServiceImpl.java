package com.ing.matrimony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.matrimony.dto.UserDto;
import com.ing.matrimony.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto register(UserDto userDto) {
		if(userDto.getPassword().equals(userDto.getConfirmPassword())) {
			userRepository.save()
		}
		
		return null;
	}

}
