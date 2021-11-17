package com.commsult.security;

import com.commsult.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/v1/users/register").permitAll()
            .antMatchers("/api/v1/users/login").permitAll()
            .antMatchers("/api/v1/stocks").permitAll()
            .antMatchers("/api/v1/stocks/{id}").permitAll()
            .antMatchers("/api/v1/users").permitAll()
            .antMatchers("/api/v1/users/{id}").permitAll()
            .antMatchers("/api").permitAll()
            .anyRequest().fullyAuthenticated()
            .and().httpBasic();

        // http.authorizeRequests()
        //     .antMatchers("/api/users/register").permitAll()
        //     .antMatchers("/api/users/login").permitAll()
        //     .antMatchers("/api/home").permitAll()
        //     .anyRequest().authenticated()
        //     .and()
        //     .csrf().disable().formLogin()
        //     .loginPage("/api/home")
        //     .failureUrl("/api/home?error=true")
        //     .defaultSuccessUrl("/api/home")
        //     .usernameParameter("email")
        //     .passwordParameter("password")
        //     .and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);

        return provider;
    }
}
