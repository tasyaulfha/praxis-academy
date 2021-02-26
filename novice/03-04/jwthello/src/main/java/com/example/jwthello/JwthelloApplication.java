package com.example.jwthello;

import com.example.jwthello.config.SignInDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@SpringBootApplication
@RestController
public class JwthelloApplication {

	@Autowired(required = true)
	private AuthenticationManager authenticationManager;

	public static void main(String[] args) {
		SpringApplication.run(JwthelloApplication.class, args);
	}
	@RequestMapping(path = "/hello")
	public String hello(){
		return "Hello world";
	}
	@PostMapping("/signin")
	public Authentication signIn(@RequestBody @Valid SignInDto signInDto){
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInDto.getUsername(),signInDto.getPassword()));
	}


}
