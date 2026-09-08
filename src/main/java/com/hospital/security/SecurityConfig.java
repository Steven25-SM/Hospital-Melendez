package com.hospital.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authenticationProvider(authenticationProvider())

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/css/**",
                                "/images/**",
                                "/",
                                "/login",
                                "/registro"
                        ).permitAll()

                        .requestMatchers(
                                "/pacientes/**",
                                "/hospitalizacion/**"
                        ).hasRole("ADMIN")

                        .requestMatchers("/medicos").hasAnyRole("ADMIN", "PACIENTE")

                        .requestMatchers(
                                "/medicos/guardar",
                                "/medicos/editar/**",
                                "/medicos/eliminar/**"
                        ).hasRole("ADMIN")

                        .requestMatchers("/citas/**")
                        .hasAnyRole("ADMIN", "PACIENTE")

                        .requestMatchers("/facturacion/**")
                        .hasAnyRole("ADMIN", "PACIENTE")

                        .anyRequest().authenticated()
                )

                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                )

                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}