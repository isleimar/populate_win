package com.win.resources;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.win.generator.dto.PeopleGeneratorDto;
import com.win.generator.dto.ProductGeneratorDto;
import com.win.generator.dto.ShopGeneratorDto;

@FeignClient(name="generator", url="${generator.host}:${generator.port}/api/${generator.version}")
public interface GeneratorResource {
	
	@GetMapping(value="people?count={count}", produces = "application/json")
	List<PeopleGeneratorDto> getPeopleGeneratorDtos(@PathVariable("count") Integer count);
	
	@GetMapping(value="shop?count={count}", produces = "application/json")
	List<ShopGeneratorDto> getShopGeneratorDtos(@PathVariable("count") Integer count);
	
	@GetMapping(value="product/rnd?count={count}", produces = "application/json")
	List<ProductGeneratorDto> getProductGeneratorDtos(@PathVariable("count") Integer count);
	
	@GetMapping(value = "lorem/bytes?count={count}&hasIntro=false", produces = "text/plain")
	String getLoremBytes(@PathVariable("count") Integer count);
	
	

}
