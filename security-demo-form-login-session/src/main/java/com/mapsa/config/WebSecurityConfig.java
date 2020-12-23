package com.mapsa.config;

import com.mapsa.model.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
//        passwordEncoder().matches()
        return new BCryptPasswordEncoder();
    }

    // AuthN
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user")
//                .password("password")
//                .roles("USER")
//                .and()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
//        auth.authenticationProvider()
    }

    // AuthZ
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and().authorizeRequests().anyRequest().authenticated();
        http.formLogin()
                .defaultSuccessUrl("/")
//                .loginPage()
//                .loginProcessingUrl()
//                .usernameParameter()
//                .passwordParameter()
                .and()
                .logout()
//                .logoutSuccessUrl()
//                .logoutUrl()
                .and()
                .authorizeRequests()
                .antMatchers("/register/**","/hello/**").permitAll()
                .antMatchers("/delete/**").hasAuthority(Roles.ADMIN.getAuthority())
                .anyRequest().authenticated();
    }

    // General Configs
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2-console/**")
                .antMatchers("/**/*.css")
                .antMatchers("/**/*.js")
                .and()
                .debug(true);
//        web.debug(true);
    }
}
