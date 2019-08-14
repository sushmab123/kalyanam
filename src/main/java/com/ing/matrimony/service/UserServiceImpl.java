package com.ing.matrimony.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.matrimony.dto.UserDto;
import com.ing.matrimony.dto.UserResponseDto;
import com.ing.matrimony.entity.User;
import com.ing.matrimony.exception.PasswordNotMatchException;
import com.ing.matrimony.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserResponseDto register(UserDto userDto) {
		User user;
		UserResponseDto userResponseDto;
		if (userDto != null) {
			if (userDto.getPassword().equals(userDto.getConfirmPassword())) {
				user = new User();
				String birthDay = userDto.getDateOfBirth();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dob = LocalDate.parse(birthDay, formatter);

				BeanUtils.copyProperties(userDto, user);
				user.setDateOfBirth(dob);
				User responseUser = userRepository.save(user);
				userResponseDto = new UserResponseDto();
				userResponseDto.setUserId(responseUser.getUserId());
				userResponseDto.setMessage("Registration Successful");
				return userResponseDto;
			} else {
				throw new PasswordNotMatchException();
			}
		} else {
			userResponseDto = new UserResponseDto();
			return userResponseDto;
		}

	}

}
