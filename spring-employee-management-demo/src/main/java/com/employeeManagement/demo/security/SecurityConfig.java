package com.employeeManagement.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain createSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .mvcMatchers( HttpMethod.GET, "/api/v-0-1/employee/**").hasAnyAuthority("USER","ADMIN")
                .mvcMatchers( HttpMethod.PUT, "/api/v-0-1/employee/**").hasAnyAuthority("USER","ADMIN")
                .mvcMatchers( HttpMethod.DELETE, "/api/v-0-1/employee/**").hasAnyAuthority("USER","ADMIN")
                .mvcMatchers("/api/v-0-1/employee/**").hasAuthority("ADMIN")
                .mvcMatchers("/api/v-0-1/auth/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();

        return httpSecurity.build();
    }

  

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}