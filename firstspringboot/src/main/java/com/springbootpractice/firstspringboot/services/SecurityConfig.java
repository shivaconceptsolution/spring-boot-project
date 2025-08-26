package com.springbootpractice.firstspringboot.services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  public PasswordEncoder passwordEncoder() {
   // return new BCryptPasswordEncoder(); // default strength 10
	  return NoOpPasswordEncoder.getInstance();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeHttpRequests(auth -> auth
           .requestMatchers("/api/reg","/api/login","/h2-console/**").permitAll()
           .anyRequest().authenticated())
        .headers(headers -> headers.frameOptions().disable()) // allow H2 console frames
        .httpBasic(Customizer.withDefaults());
    return http.build();
  }
}

