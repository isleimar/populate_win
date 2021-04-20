package com.win.services;

import java.util.Arrays;
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
	@Autowired
	CategoryService categoryService;
	
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
				.productStatus(getProductStatus())
				.productCategories(categoryService.getListCategory(p.getCategories()))
				.name(p.getName())
				.description(p.getDescription())
				.isDivisible(RandomUtil.getRandomInt(2)==0)
				.likes(RandomUtil.getRandomInt(1000))
				.price(p.getPrice())
				.stock(RandomUtil.getDoubleRandom(0.0, 50.0))
				.score(RandomUtil.getRandomInt(1000))
				.build();
	}
	
	private String  getProductStatus() {
		return RandomUtil.getRandomItemList(Arrays.asList(ProductWinDto.PRODUCT_STATUS));
	}

}
