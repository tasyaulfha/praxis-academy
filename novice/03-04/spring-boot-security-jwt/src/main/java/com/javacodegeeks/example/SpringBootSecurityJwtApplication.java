package com.javacodegeeks.example;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootSecurityJwtApplication {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtProvider jwtProvider;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

	@RequestMapping("/hello")
	public String hello() {
		return "Hello world";
	}

//	@PostMapping("/signin")
//	public Authentication signIn(@RequestBody @Valid SignInDto signInDto) {
//		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInDto.getUsername(), signInDto.getPassword()));
//	}

	@PostMapping("/signin")
	public String signIn(@RequestBody @Valid SignInDto signInDto) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInDto.getUsername(), signInDto.getPassword()));
			return jwtProvider.createToken(signInDto.getUsername());
		} catch (AuthenticationException e){
            System.out.println("Log in failed for user, " + signInDto.getUsername());
        }

		return "";
	}

}
