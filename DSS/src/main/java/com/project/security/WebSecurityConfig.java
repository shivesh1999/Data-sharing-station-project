package com.project.security;


import com.project.Services.UserService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter { // Extending the security interface by spring security
	
	@Autowired
    private  UserService userService;
	
	
//    private  BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//    // by WebSecurityConfigurerAdapter
	
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/institute/**").hasRole("INSTITUTE")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
        ;
    }

    // by WebSecurityConfigurerAdapter
//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvide());
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvide(){
//        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(bCryptPasswordEncoder);
//        provider.setUserDetailsService(userService);
//        return provider;
//    }


}
