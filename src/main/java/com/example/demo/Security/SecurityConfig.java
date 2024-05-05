package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http, HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .formLogin(Customizer.withDefaults()).
                httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authCustomizer->authCustomizer
                                .requestMatchers("/CategoryPanel","/CreateCategory","/DeleteCategory","/SaveCategory","/AllPosts","/CreatePost",
                                        "/DeletePost","/DeletePost","/UpdateCategory",
                                        "/UpdateBlogPost","/ShowPost").hasRole("ADMIN")
                                .requestMatchers("/").hasAnyRole("ADMIN","CLIENT")
                                .anyRequest().authenticated())
                .exceptionHandling(e->e.accessDeniedPage("/Access_Denied"))


                .build();

    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(bCryptPasswordEncoder().encode("admin@123")).roles("ADMIN").build(),
                User.withUsername("client").password(bCryptPasswordEncoder().encode("123")).roles("CLIENT").build()
        );
    }
}
