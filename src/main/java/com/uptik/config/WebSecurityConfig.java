package com.uptik.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home").hasAnyAuthority("SUPER_USER", "ADMIN_USER", "SITE_USER")
                .antMatchers("/", "/login", "/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                // form login
                .formLogin()
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                // Resources should be ignored to prevent redirecting to them after login.
                .antMatchers("/css/**", "/**/js/**", "/img/**", "/fonts/**", "/favicon.ico**");
    }

    //bcrypt bean definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
