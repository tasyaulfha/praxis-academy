package com.example.bankmanagement.service.UserServiceImpl;

import com.example.bankmanagement.model.User;
import com.example.bankmanagement.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserSecurityService.class);
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findByUsername(username);
        if(null==user){
            LOG.warn("Username{} not found", username);
            throw new UsernameNotFoundException("Username"+username+"not found");
        }
        return user;
    }
}
