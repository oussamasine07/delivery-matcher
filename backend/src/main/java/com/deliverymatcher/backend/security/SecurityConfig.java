package com.deliverymatcher.backend.security;

import com.deliverymatcher.backend.filter.JwtFilter;
import com.deliverymatcher.backend.service.JwtService;
import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.deliverymatcher.backend.model.Permission.*;
import static com.deliverymatcher.backend.model.Role.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    public SecurityConfig (
            final JwtFilter jwtFilter
    ) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (
            HttpSecurity http
    ) throws Exception {

        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()  // Allow all OPTIONS requests for CORS preflight
                        .requestMatchers( "/user/register" ).hasAnyAuthority()
                        .requestMatchers( "/user/login" ).hasAnyAuthority()
                        .requestMatchers( "/admin/login" ).hasAnyAuthority()
                        // driver permissions
                        .requestMatchers( "/api/v1/announcement/**" ).hasAnyRole(ADMIN.name(), DRIVER.name())
                        .requestMatchers( HttpMethod.GET, "/api/v1/announcement/**").hasAnyAuthority(ADMIN_READ.name(), DRIVER_READ.name())
                        .requestMatchers( HttpMethod.POST, "/api/v1/announcement/**").hasAnyAuthority(ADMIN_CREATE.name(), DRIVER_CREATE.name())
                        .requestMatchers( HttpMethod.PUT, "/api/v1/announcement/**").hasAnyAuthority(ADMIN_UPDATE.name(), DRIVER_UPDATE.name())
                        .requestMatchers( HttpMethod.DELETE, "/api/v1/announcement/**").hasAnyAuthority(ADMIN_DELETE.name(), DRIVER_DELETE.name())

                        .requestMatchers(  "/api/v1/journy/**" ).hasAnyRole(ADMIN.name(), DRIVER.name())
                        .requestMatchers( HttpMethod.GET, "/api/v1/journy/**").hasAnyAuthority(ADMIN_READ.name(), DRIVER_READ.name())
                        .requestMatchers( HttpMethod.POST, "/api/v1/journy/**").hasAnyAuthority(ADMIN_CREATE.name(), DRIVER_CREATE.name())
                        .requestMatchers( HttpMethod.PUT, "/api/v1/journy/**").hasAnyAuthority(ADMIN_UPDATE.name(), DRIVER_UPDATE.name())
                        .requestMatchers( HttpMethod.DELETE, "/api/v1/journy/**").hasAnyAuthority(ADMIN_DELETE.name(), DRIVER_DELETE.name())

                        // sender permissions
                        .requestMatchers( HttpMethod.GET,  "/api/v1/announcement" ).hasAnyRole(SENDER.name())
                        .requestMatchers( "/api/v1/application/**" ).hasAnyRole(SENDER.name())
                        .requestMatchers( HttpMethod.GET, "/api/v1/application/**").hasAnyAuthority(ADMIN_READ.name(), SENDER_READ.name())
                        .requestMatchers( HttpMethod.POST, "/api/v1/application/**").hasAnyAuthority(ADMIN_CREATE.name(), SENDER_CREATE.name())
                        .requestMatchers( HttpMethod.PUT, "/api/v1/application/**").hasAnyAuthority(ADMIN_UPDATE.name(), SENDER_UPDATE.name())
                        .requestMatchers( HttpMethod.DELETE, "/api/v1/application/**").hasAnyAuthority(ADMIN_DELETE.name(), SENDER_DELETE.name())
                        .anyRequest()
                        .authenticated()  // Other requests need auth
                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider (UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }


    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration config)
            throws Exception
    {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }
}
