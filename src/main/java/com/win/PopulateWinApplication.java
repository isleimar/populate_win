package com.win;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.win.services.PopulateService;

@SpringBootApplication
@EnableFeignClients
public class PopulateWinApplication implements CommandLineRunner{
	
	@Autowired
	PopulateService populateService;
	

	public static void main(String[] args) {
		SpringApplication.run(PopulateWinApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Start....");
		populateService.stratPopulate();
		System.out.println("Concluído.");
	}

}
