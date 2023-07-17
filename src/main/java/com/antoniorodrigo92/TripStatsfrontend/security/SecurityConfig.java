package com.antoniorodrigo92.TripStatsfrontend.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SecurityConfig {
    @Value("${user.name}")
    private String user;
    @Value("${user.password}")
    private String password;

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails user = User.builder()
                .username(this.user)
                .password("{noop}" + this.password)
                .roles("BIGDICK")
                .build();

        return new InMemoryUserDetailsManager(user);

    }

}
