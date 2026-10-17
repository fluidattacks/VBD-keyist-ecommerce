package com.commerce.backend.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(95)
public class TuningSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(new AntPathRequestMatcher("/actuator/**"))
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
