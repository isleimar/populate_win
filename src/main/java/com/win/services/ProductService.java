package com.win.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.win.dto.ProductWinDto;
import com.win.generator.dto.ProductGeneratorDto;
import com.win.resources.GeneratorResource;

@Service
public class ProductService {
	
	@Autowired
	GeneratorResource generatorResource;
	
	@Value("${product.count}")
	private int count;
	
	public List<ProductWinDto> getProductWinDtos(){
		return generatorResource.getProductGeneratorDtos(count)
			.stream()
			.map(p -> dtoToProduc(p))
			.collect(Collectors.toList());
	}
	
	private ProductWinDto dtoToProduc(ProductGeneratorDto p) {
		return ProductWinDto
				.builder()
				.name(p.getName())
				.description(p.getDescription())
				.price(p.getPrice())
				.build();
	}

}
