package com.example.online_catalogue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("simple")
                .password("{noop}pass")
                .roles("USER")

                .and()

                .withUser("admin")
                .password("{noop}pass")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/adminPage").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }



}
