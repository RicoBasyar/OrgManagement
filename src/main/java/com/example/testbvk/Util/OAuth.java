package com.example.testbvk.Util;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class OAuth{

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                authorizeRequests -> {
                    authorizeRequests.requestMatchers("/testBVK/user/registerUser").permitAll();
                    authorizeRequests.requestMatchers("/testBVK/user/login").permitAll();
                    authorizeRequests.requestMatchers("/testBVK/user/oauth2/redirect").permitAll();
                    authorizeRequests.anyRequest().authenticated();
                })
                .oauth2Login()
                .defaultSuccessUrl("/testBVK/user/oauth2/redirect", true)
                .and()
                .csrf().disable()
                .build();
    }

}
