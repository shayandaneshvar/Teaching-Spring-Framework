package com.mapsa.filter;

import com.mapsa.model.User;
import com.mapsa.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BeforeAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final UserRepository userRepository;

    {
        super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
//        super.setUsernameParameter();
//        super.setPasswordParameter();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Optional<User> optional = userRepository.findAllByName(request.getParameter("username"));
        if (optional.isEmpty()) {
            return super.attemptAuthentication(request, response);
        }
        User user = optional.get();
        if (user.getOneTimePassword() != null && user.getOneTimePassword().hasExpired()) {
            try {
                response.sendRedirect("/forgot-password?expire=true&email=" + user.getEmail());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
//            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
//            response.setHeader("Location", "/forgot-password?expire=true&email=" + user.getEmail());
        }
        return super.attemptAuthentication(request, response);
    }


    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    @Autowired
    public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
        super.setAuthenticationSuccessHandler(successHandler);
    }

    @Override
    @Autowired
    public void setAuthenticationFailureHandler(AuthenticationFailureHandler failureHandler) {
        super.setAuthenticationFailureHandler(failureHandler);
    }
}
