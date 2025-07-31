package com.mrk.config;

// Modern Spring Boot 3.x Security Configuration
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// Modern Spring Boot 3.x and Spring Security 6.x configuration
// Replaces deprecated WebSecurityConfigurerAdapter with component-based configuration
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    // Modern Spring Security 6.x: SecurityFilterChain bean replaces WebSecurityConfigurerAdapter
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            // Modern HTTP Basic authentication configuration
            .httpBasic(httpBasic -> httpBasic.realmName("Book API"))
            // Modern authorization configuration with requestMatchers
            .authorizeHttpRequests(authz -> authz
                .requestMatchers(HttpMethod.GET, "/books/**").hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/books/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PATCH, "/books/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/books/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            // Modern CSRF and form login configuration
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form.disable())
            .build();
    }

    // Modern Spring Security 6.x: UserDetailsService bean for in-memory authentication
    @Bean
    public UserDetailsService userDetailsService() {
        // Modern user creation with Java 24 features
        UserDetails user = User.builder()
            .username("user")
            .password("{noop}password")
            .roles("USER")
            .build();
            
        UserDetails admin = User.builder()
            .username("admin")
            .password("{noop}password")
            .roles("USER", "ADMIN")
            .build();

        // Java 24: Modern collection creation
        return new InMemoryUserDetailsManager(user, admin);
    }

}
