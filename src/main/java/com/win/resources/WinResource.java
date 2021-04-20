package com.win.resources;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.win.dto.AdministratorWinDto;
import com.win.dto.ClientWinDto;
import com.win.dto.VendorWinDto;
import com.win.generator.dto.ProductCategoryGeneratorDto;

@FeignClient(name="win", url="localhost:8080/api/v1")
public interface WinResource {
	
	@PutMapping("/client/")
	void putClient(@RequestBody ClientWinDto clientWinDto);
	
	@PutMapping("/administrator/")
	void putAdministrator(@RequestBody AdministratorWinDto administratorWinDto);
	
	@PutMapping("/vendor/")
	void putVendor(@RequestBody VendorWinDto vendorWinDto);
	
	@PutMapping("/product_category/")
	ProductCategoryGeneratorDto putCategoria(@RequestBody ProductCategoryGeneratorDto vendorWinDto);
	
	
	

}
