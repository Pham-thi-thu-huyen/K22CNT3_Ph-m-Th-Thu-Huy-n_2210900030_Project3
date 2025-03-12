package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthUser;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.repository.UserRepository;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("Attempting to load user: " + email);
        PtthUser user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    logger.error("User not found: " + email);
                    return new UsernameNotFoundException("User not found with email: " + email);
                });
        logger.info("User found: " + user.getEmail() + ", Password: " + user.getPassword() + ", Role: " + user.getRole());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
        );
    }
}