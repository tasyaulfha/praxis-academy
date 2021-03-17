package com.example.projek.security.services;

import com.example.projek.model.User;
import com.example.projek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = (User) userRepository.findByUsername(username)
                    .orElseThrow(()-> new UsernameNotFoundException("user not found with -> username "+
                    "or email" + username));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return UserPrinciple.build(user);

    }

}