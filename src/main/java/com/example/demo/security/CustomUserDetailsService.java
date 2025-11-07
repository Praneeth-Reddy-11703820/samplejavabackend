package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Dummy user: username=user, password=password
        if (username.equals("user")) {
            return User.builder()
                    .username("user")
                    .password("{noop}password") // {noop} = no encoding
                    .roles("USER")
                    .build();
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
