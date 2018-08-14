package com.palmatolay.basic
/*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

import org.apache.tomcat.jni.User.username
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.beans.factory.annotation.Autowired



@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!
            .inMemoryAuthentication()
                .withUser("usr")
                .password("pwd")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("USER", "ADMIN")
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .authorizeRequests()
                .antMatchers("/", "/test/create_use").permitAll()
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/users").hasRole("ADMIN")
                .and()
//            .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login-error")
//                .permitAll()
//                .and()
            .logout().permitAll()
    }

//    @Bean
//    override fun userDetailsService(): UserDetailsService {
//        val user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("pwd")
//                .roles("USER")
//                .build()
//        return InMemoryUserDetailsManager(user)
//    }
}
*/