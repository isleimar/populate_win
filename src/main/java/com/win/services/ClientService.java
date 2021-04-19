package com.win.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.win.dto.ClientWinDto;
import com.win.generator.dto.PeopleGeneratorDto;
import com.win.resources.WinResource;

@Service
public class ClientService {
	
	@Autowired
	PeopleService peopleService;
	@Autowired
	WinResource winResource;
	
	@Value("${client.count}")
	private int count;
	
	public void createClient() {		
		peopleService.getListPeopleGeneratorDtos(count)
			.stream()
			.map(p -> dtoToClient(p))
			.collect(Collectors.toList())
				.forEach(c -> winResource.putClient(c));
	}
	
	private ClientWinDto dtoToClient(PeopleGeneratorDto p) {		
		return ClientWinDto
				.builder()
				.userName(p.getUsername())
				.password(p.getPassword())
				.userStatus(peopleService.getRandomUserStatus())
				.people(peopleService.dtoToPeople(p))
				.score(10)
				.build();
				
	}

}
