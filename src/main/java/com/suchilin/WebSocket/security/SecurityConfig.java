package com.suchilin.WebSocket.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    public void autoConfigure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1")
                .password("{noop}password")
                .roles("GUEST")
                .and()
                .withUser("user2")
                .password("{noop}password")
                .roles("GUEST")
                .and()
                .withUser("user3")
                .password("{noop}password")
                .roles("GUEST");
    }
}
