package com.gwennies.eindopdracht;

import javax.annotation.Resource;

import com.gwennies.eindopdracht.service.FilesStorageService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EindopdrachtApplication implements CommandLineRunner {
	@Resource
  	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(EindopdrachtApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
	  storageService.deleteAll();
	  storageService.init();
	}

}
