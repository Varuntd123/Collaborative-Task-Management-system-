package com.collabtask.config;

import com.collabtask.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users/**").hasAnyRole("ADMIN", "MANAGER")
                .requestMatchers("/api/teams/**").hasRole("ADMIN")
                .requestMatchers("/api/tasks/**").hasAnyRole("ADMIN", "MANAGER", "MEMBER")
                .requestMatchers("/api/comments/**").hasAnyRole("ADMIN", "MANAGER", "MEMBER")
                .anyRequest().authenticated()
            )
            .httpBasic(); // For demo, use HTTP Basic Auth
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
