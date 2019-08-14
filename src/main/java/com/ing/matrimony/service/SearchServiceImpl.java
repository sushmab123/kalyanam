package com.ing.matrimony.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.matrimony.entity.User;
import com.ing.matrimony.repository.ProfileRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private ProfileRepository profileRepository;
	
	
	@Override
	public List<User> search(int fromAge, int toAge, String gender) {

		List<User> searchProfiles=profileRepository.findByAgeRangeAndGender(fromAge, toAge, gender);
		
		return searchProfiles;
	}

}
