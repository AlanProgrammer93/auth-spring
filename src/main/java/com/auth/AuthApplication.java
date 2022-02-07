package com.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.auth.domain.Role;
import com.auth.domain.User;
import com.auth.service.UserService;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;;

@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			
			userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
			
			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("jim", "ROLE_USER");
			userService.addRoleToUser("jim", "ROLE_MANAGER");
			userService.addRoleToUser("will", "ROLE_ADMIN");
			userService.addRoleToUser("will", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("will", "ROLE_MANAGER");
		};
	}

}