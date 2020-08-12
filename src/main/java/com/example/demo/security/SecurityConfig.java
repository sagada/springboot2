package com.example.demo.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        log.info("security configure method");

        http.authorizeRequests().antMatchers("/guest/**").permitAll();

        http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");

        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

        http.formLogin().loginPage("/login");

        http.exceptionHandling().accessDeniedPage("/accessDenied");

        http.logout().logoutUrl("/logout").invalidateHttpSession(true);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        log.info("configureGlobal method");

        auth.inMemoryAuthentication()
                .withUser("manager")
                .password("1111")
                .roles("MANAGER");
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return charSequence.equals(s);
            }
        };
    }


}
