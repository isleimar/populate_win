package com.win.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.dto.PeopleWinDto;
import com.win.dto.UserWinDto;
import com.win.generator.dto.PeopleGeneratorDto;
import com.win.resources.GeneratorResource;

@Service
public class PeopleService {
	
	@Autowired
	GeneratorResource generatorResource;
	
	public List<PeopleGeneratorDto> getListPeopleGeneratorDtos(int count) {		
		return generatorResource.getPeopleGeneratorDtos(count);
	}
	
	public PeopleWinDto dtoToPeople(PeopleGeneratorDto peopleGeneratorDto) {
		return PeopleWinDto
				.builder()
				.name(peopleGeneratorDto.getName())
				.gender(peopleGeneratorDto.getGender())
				.birthdate(peopleGeneratorDto.getBirthdate())
				.build();
	}
	
	public String getRandomUserStatus() {
		return RandomUtil.getRandomItemList(
					Arrays.asList(UserWinDto.USER_STATUS)
				);
	}

}
