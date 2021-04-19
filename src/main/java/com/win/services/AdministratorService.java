package com.win.services;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.win.dto.AdministratorWinDto;
import com.win.generator.dto.PeopleGeneratorDto;
import com.win.resources.WinResource;

@Service
public class AdministratorService {
	
	@Autowired
	PeopleService peopleService;
	@Autowired
	WinResource winResource;
	
	@Value("${adminitrator.count}")
	private int count;
	
	public void createAdministrator() {
		peopleService.getListPeopleGeneratorDtos(count)
			.stream()
			.map(p -> dtoToAdministrator(p))
			.collect(Collectors.toList())
				.forEach(a -> winResource.putAdministrator(a));
	}
	
	private AdministratorWinDto dtoToAdministrator(PeopleGeneratorDto p) {
		return AdministratorWinDto
				.builder()
				.userName(p.getUsername())
				.password(p.getPassword())
				.userStatus(peopleService.getRandomUserStatus())
				.people(peopleService.dtoToPeople(p))
				.administratorLevel(getRandomAdministratorLevel())
				.build();
	}
	
	private String getRandomAdministratorLevel() {
		return RandomUtil.getRandomItemList(
					Arrays.asList(AdministratorWinDto.ADMINISTRATOR_LEVELS)
				);
	}

}
