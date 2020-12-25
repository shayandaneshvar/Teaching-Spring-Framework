package com.mapsa.services;


import com.mapsa.model.OneTimePassword;
import com.mapsa.model.Roles;
import com.mapsa.model.User;
import com.mapsa.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, CommandLineRunner/*, ApplicationRunner*/ {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;

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
        user.setEmail("aa@aa.com");
        user.setPassword(passwordEncoder.encode("password"));
        userRepository.save(user);
    }

    public void sendOtp(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        String otpContent = generateOtp();
        OneTimePassword oneTimePassword = new OneTimePassword()
                .setContent(passwordEncoder.encode(otpContent))
                .setCreationDate(new Date());
        user.setOneTimePassword(oneTimePassword);
        try {
            mailService.sendOtp(user, otpContent);
        } catch (UnsupportedEncodingException | MessagingException e) {
            e.printStackTrace();
        }
        userRepository.save(user);
    }

    private String generateOtp() {
        return RandomString.make(6);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        args.getSourceArgs();
//    }
}
