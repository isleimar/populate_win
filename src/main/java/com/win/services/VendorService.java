package com.win.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.win.dto.ShopWinDto;
import com.win.dto.VendorWinDto;
import com.win.generator.dto.PeopleGeneratorDto;
import com.win.resources.WinResource;

@Service
public class VendorService {
	
	@Autowired
	PeopleService peopleService;
	@Autowired
	ShopService shopService;
	@Autowired
	WinResource winResource;
	
	@Value("${vendor.count}")
	int count;
	
	public void createVendor() {
		List<VendorWinDto> vendors = peopleService.getListPeopleGeneratorDtos(count)
			.stream()
			.map(p -> dtoVendor(p))
			.collect(Collectors.toList());
		List<ShopWinDto> shops = shopService.getShopWinDtos(count);		
		for (VendorWinDto v : vendors) {
			if (shops.size() > 0) {
				ShopWinDto s = shops.remove(0);				
				v.setShop(s);
				s.setVendor(v);
			}
			winResource.putVendor(v);
		}	
	}
	
	private VendorWinDto dtoVendor(PeopleGeneratorDto p) {
		return VendorWinDto
				.builder()
				.userName(p.getUsername())
				.password(p.getPassword())
				.userStatus(peopleService.getRandomUserStatus())
				.people(peopleService.dtoToPeople(p))
				.score(RandomUtil.getRandomInt(1000))
				.build();
	}
	
}
