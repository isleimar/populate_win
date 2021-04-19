package com.win.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.dto.ShopWinDto;
import com.win.generator.dto.ShopGeneratorDto;
import com.win.resources.GeneratorResource;

@Service
public class ShopService {
	
	@Autowired
	GeneratorResource generatorResource;
	@Autowired
	ProductService productService;
	
	public List<ShopWinDto> getShopWinDtos(int count){
		return generatorResource.getShopGeneratorDtos(count)
			.stream()
			.map(s -> dtoToShop(s))
			.collect(Collectors.toList());
	}
	
	private ShopWinDto dtoToShop(ShopGeneratorDto s) {
		ShopWinDto shop = ShopWinDto
				.builder()
				.registry(s.getRegistry())
				.companyName(s.getCompanyName())
				.products(productService.getProductWinDtos())
				.tradeName(s.getTradeName())
				.build();
		shop.getProducts().forEach(p -> p.setShop(shop));		
		return shop;
	}

}
