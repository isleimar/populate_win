package com.win.services;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.generator.dto.ProductCategoryGeneratorDto;
import com.win.resources.GeneratorResource;
import com.win.resources.WinResource;

@Service
public class CategoryService {
	 
	private HashMap<String, ProductCategoryGeneratorDto> categoryKeys;
	
	@Autowired
	WinResource winResource;
	@Autowired
	GeneratorResource generatorResource;
	
	public List<ProductCategoryGeneratorDto> getListCategory(List<String> categoryNames){
		return categoryNames
				.stream()
				.map(c -> getCategory(c))
				.collect(Collectors.toList());
	}
	
	public ProductCategoryGeneratorDto getCategory(String categoryName) {
		if (categoryKeys == null) categoryKeys = new HashMap<String, ProductCategoryGeneratorDto>();
		if (categoryKeys.containsKey(categoryName)) {
			return categoryKeys.get(categoryName);
		}
		return createCategory(categoryName);
	}
	
	private ProductCategoryGeneratorDto createCategory(String categoryName) {
		ProductCategoryGeneratorDto category = ProductCategoryGeneratorDto
				.builder()
				.name(categoryName)
				.description(generatorResource.getLoremBytes(RandomUtil.getRandomInt(30, 254)))
				.build();
		category = winResource.putCategoria(category);
		categoryKeys.put(categoryName, category);
		return category;
	}
	
	
	

}
