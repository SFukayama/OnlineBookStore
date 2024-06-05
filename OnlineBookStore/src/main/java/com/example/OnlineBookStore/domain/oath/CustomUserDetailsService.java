package com.example.OnlineBookStore.domain.oath;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("tom".equals(username)) {
            String encodedPassword = passwordEncoder.encode("password");
            return new CustomUserDetails("tom", encodedPassword, Collections.emptyList());
        }
        throw new UsernameNotFoundException(
                "not found.(username = '" + username + "')"
        );
    }
}
