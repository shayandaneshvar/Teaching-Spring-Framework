package com.mapsa.securityjwtdemo.service;

import com.mapsa.securityjwtdemo.domain.User;
import com.mapsa.securityjwtdemo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow();
        return new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), user.getRoles());
    }
}
