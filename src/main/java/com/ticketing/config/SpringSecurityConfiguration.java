package com.ticketing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    //Authentication
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //Set the configuration here
//                auth.inMemoryAuthentication()
//                        .withUser("ravi")
//                        .password("123456")
//                        .roles("ADMIN")
//                        .and()
//                        .withUser("asep")
//                        .password("123456")
//                        .roles("USER");
//    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select email, password, enabled " +
//                        "from client " +
//                        "where email = ?")
//                .authoritiesByUsernameQuery("select user_name, authority_name " +
//                        "from authority " +
//                        "where user_name = ?");
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService();
    }


    //Hashing password
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }

    //Authorization

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Set the configuration here
        http.authorizeRequests()
                .antMatchers("/", "static/css", "static/js")
                .permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER", "ADMIN")
                .and().formLogin();
    }
}
