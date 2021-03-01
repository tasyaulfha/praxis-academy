package com.example.bankmanagement.service.UserServiceImpl;


import com.example.bankmanagement.model.User;
import com.example.bankmanagement.security.UserRole;
import com.example.bankmanagement.repository.RoleRepository;
import com.example.bankmanagement.repository.UserRepository;
import com.example.bankmanagement.service.AccountService;
import com.example.bankmanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger LOG= LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AccountService accountService;

    public void save(User user){
        userRepository.save(user);
    }
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User createUser(User user, Set<UserRole> userRoles){
        User localUser = userRepository.findByUsername(user.getUsername());

        if (localUser !=null){
            LOG.info("User with username{} already exist. Nothing will be done  ", user.getUsername());
        }
        else {
            String encryptedPassword=passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for (UserRole ur : userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);

            user.setPrimaryAccount(accountService.createPrimaryAccount());
            user.setSavingsAccount(accountService.createSavingsAccount());

            localUser = userRepository.save(user);
        }
        return localUser;
    }

    public boolean checkUserExists(String username, String email){
        return checkUsernameExists(username) || checkEmailExists(username);
    }
    public boolean checkUsernameExists(String username){
        return null != findByUsername(username);
    }
    public boolean checkEmailExists(String email){
        return  null != findByEmail(email);
    }
    public User saveUser (User user){
        return userRepository.save(user);
    }
    public List<User> findUserList(){
        return userRepository.findAll();
    }
    public void enableUser(String username){
        User user= findByUsername(username);
        user.setEnabled(true);
        userRepository.save(user);
    }
    public void disableUser(String username){
        User user = findByUsername(username);
        user.setEnabled(false);
        LOG.info("user status: {}",user.isEnabled());
        userRepository.save(user);
        LOG.info(username,"{}, is disabled");
    }


}
