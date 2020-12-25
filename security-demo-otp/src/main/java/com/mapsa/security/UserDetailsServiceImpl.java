package com.mapsa.security;

import com.mapsa.model.User;
import com.mapsa.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserPrincipal loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findAllByName(s)
                .or(() -> userRepository.findByEmail(s)).orElseThrow();

//        Optional<User> u = userRepository.findAllByName(s);
//        User user1;
//        if(u.isPresent()){
//            user1 = u.get();
//        }else if()

        return new UserPrincipal(user);
//        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), user.getRoles());
    }
}
