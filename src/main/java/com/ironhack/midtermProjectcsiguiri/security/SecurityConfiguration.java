package com.ironhack.midtermProjectcsiguiri.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Carolina").password(passwordEncoder().encode("1234")).roles("ADMIN")
                .and()
                .withUser("Emily").password(passwordEncoder().encode("popesa")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .mvcMatchers("/account-balance/{id}").authenticated()
                .mvcMatchers("/consult-balance/{id}").hasRole("ADMIN")
                .mvcMatchers("/balance-transfer").hasRole("ADMIN")
                .mvcMatchers("/consult-balance").hasRole("ADMIN")
                .mvcMatchers("/balance-transfer").permitAll()
                .anyRequest().permitAll();
    }
}
