package com.mapsa.thymeleaf.services;

import com.mapsa.thymeleaf.model.User;
import com.mapsa.thymeleaf.repo.UserRepository;
import com.mapsa.thymeleaf.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.DispatcherServlet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, CommandLineRunner/*, ApplicationRunner*/ {
    private final UserRepository userRepository;

    @PostConstruct
    public void initialize() {
        System.out.println("==== In PostConstruct");
    }

    @PreDestroy()
    public void destroyAli() {
        System.out.println("==== Destroyed");
        userRepository.deleteByName("Ali");
    }


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(PasswordUtils.hashPassword(user.getPassword()));
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
        user.setName("Ali");
        user.setEmail("da@ags.com");
        user.setPassword(PasswordUtils.hashPassword("pasdfsword"));
        userRepository.save(user);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        args.getSourceArgs();
//    }
}
