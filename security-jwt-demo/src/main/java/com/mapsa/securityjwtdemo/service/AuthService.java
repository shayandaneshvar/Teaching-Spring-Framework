package com.mapsa.securityjwtdemo.service;

import com.mapsa.securityjwtdemo.domain.User;
import com.mapsa.securityjwtdemo.dto.AuthResponse;
import com.mapsa.securityjwtdemo.dto.LoginRequest;
import com.mapsa.securityjwtdemo.repo.UserRepository;
import com.mapsa.securityjwtdemo.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtProvider jwtProvider;

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(loginRequest.getAuth());
        UserDetails user = userDetailsService
                .loadUserByUsername(loginRequest.getUsername());
        String token = jwtProvider.generateToken(user);
        return new AuthResponse()
                .setUsername(user.getUsername())
                .setToken(token);
    }

    @Override
    public void run(String... args) {
        User user = new User().setUsername("ali")
                .setPassword(passwordEncoder.encode("password"));
        userRepository.save(user);
    }
}
