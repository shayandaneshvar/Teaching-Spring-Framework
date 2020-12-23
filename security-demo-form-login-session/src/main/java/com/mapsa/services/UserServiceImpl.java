package com.mapsa.services;


import com.mapsa.model.Roles;
import com.mapsa.model.User;
import com.mapsa.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, CommandLineRunner/*, ApplicationRunner*/ {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("==== in command line runner..");
        User user = new User();
        user.setName("ali");
        user.getRoles().add(Roles.ADMIN);
        user.setEmail("da@ags.com");
        user.setPassword(passwordEncoder.encode("password"));
        userRepository.save(user);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        args.getSourceArgs();
//    }
}
