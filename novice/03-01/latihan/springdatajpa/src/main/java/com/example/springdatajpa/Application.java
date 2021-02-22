package com.example.springdatajpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.springdatajpa.model.AppUser;
import com.example.springdatajpa.repository.AppUserRepository;

import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private AppUserRepository appUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override 
	public void run(String...args) throws Exception{
		System.out.println("Creating AppUser object: appUser1");
		AppUser appUser1= new AppUser();
		appUser1.setUsername("appUser1");
		appUser1.setFirstName("Richard");
		appUser1.setLastName("Stallman");
		appUser1.setJoinDate(new Date());
		System.out.println("appUser1 created");

		System.out.println("Creating Appuser object: appUser2");
		AppUser appUser2 = new AppUser();
		appUser2.setUsername("appuser2");
		appUser2.setFirstName("Linus");
		appUser2.setLastName("Torvalds");
		appUser2.setJoinDate(new Date());
		System.out.println("appUser2 created.");

		System.out.println("Saving appuser1 . . . ");
		this.appUserRepository.save(appUser1);
		System.out.println("appUser1 saved");

		System.out.println("Saving appuser2 . . . ");
		this.appUserRepository.save(appUser1);
		System.out.println("appUser2 saved");


	}

}
