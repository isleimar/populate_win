package com.win.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PopulateService {
	
	@Autowired
	ClientService clientService;
	@Autowired
	AdministratorService administratorService;
	@Autowired
	VendorService vendorService;
	
	public void stratPopulate() {
		clientService.createClient();
		administratorService.createAdministrator();
		vendorService.createVendor();
	}

}
