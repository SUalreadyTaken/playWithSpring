package com.su.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource);

    //        // bad practice.. using for demo only :)
    //        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
    //
    //        auth.inMemoryAuthentication()
    //                .withUser(userBuilder.username("test").password("test").roles("EMPLOYEE", "TESTER"))
    //                .withUser(userBuilder.username("manager").password("manager").roles("MANAGER"))
    //                .withUser(userBuilder.username("admin").password("admin").roles("ADMIN"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/showLoginPage").loginProcessingUrl("/authenticateUser").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
