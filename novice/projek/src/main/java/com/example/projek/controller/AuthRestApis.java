package com.example.projek.controller;


import com.example.projek.message.reques.LoginForm;
import com.example.projek.message.reques.SignUpForm;
import com.example.projek.message.response.JwtResponse;
import com.example.projek.model.Role;
import com.example.projek.model.RoleName;
import com.example.projek.model.User;
import com.example.projek.repository.RoleRepository;
import com.example.projek.repository.UserRepository;
import com.example.projek.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/jwt")

public class AuthRestApis {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping(path = "/signin")
    public ResponseEntity authenticationUser(@Valid @RequestBody LoginForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
    private String getJwt(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }

        return null;
    }

    @PostMapping(path = "/signup")
    public ResponseEntity registerUser(@Valid @RequestBody SignUpForm signUpRequest){
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity("Fail -> Username is already taken",
                    HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByEmail(signUpRequest.getEmail())){
            return new ResponseEntity("Fail-> Email is already taken",
                    HttpStatus.BAD_REQUEST);
        }
        //creating user account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role-> {
            switch (role){
                case "admin" :
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(()-> new RuntimeException("Fail-> cause : user role not find"));
                    roles.add(adminRole);
                    break;

                case "pm":
                    Role pmRole= roleRepository.findByName(RoleName.ROLE_PM).orElseThrow(()->
                            new RuntimeException("Fail-> cause : user " +
                                    "role not find"));
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(()-> new RuntimeException("Fail ->" +
                                    "cause : user role not find"));
                    roles.add(userRole);
            }
        });
                    user.setRoles(roles);
                    userRepository.save(user);

                    return ResponseEntity.ok().body("User registered successfully!");
    }

}

