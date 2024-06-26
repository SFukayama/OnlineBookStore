package com.example.OnlineBookStore.domain.oath;

import com.example.OnlineBookStore.domain.model.User;
import com.example.OnlineBookStore.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).
                map(
                        user -> new CustomUserDetails(
                                user.getUsername(),
                                passwordEncoder.encode(user.getPassword()),
                                toGrantedAuthorityList(user.getAuthority())
                        )
                )
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                "not found.(username = '" + username + "')"
                        )
                );
    }

    private List<GrantedAuthority> toGrantedAuthorityList(User.Authority authority) {
        return Collections.singletonList(new SimpleGrantedAuthority(authority.name()));
    }
}
