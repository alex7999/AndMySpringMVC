package com.andMySpringMVC.springmvc.configuration;

import com.andMySpringMVC.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

/*    @Autowired
    AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    AuthenticationFailureHandler authenticationFailureHandler;*/

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth){
        try {
            auth.userDetailsService(userService);//.passwordEncoder(bCryptPasswordEncoder());//.inMemoryAuthentication().withUser("user")
//                    .password("password").roles("Role");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS) . and ()
                .authorizeRequests()
                .antMatchers("/*").permitAll()
                .antMatchers("/role/**")//. authenticated ()
                .hasRole("ADMIN")
                .antMatchers("/user/**")//. authenticated ()
                .hasAnyRole("USER", "ADMIN")//hasRole("USER")
                .anyRequest() . authenticated ()
                .and()
                .formLogin()
//                .loginProcessingUrl("/mylogin") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/")//
//                .failureUrl("/login?error=true")//
//                .usernameParameter("username")//
//                .passwordParameter("password")
//                .defaultSuccessUrl("/user/list")//user/list
//                .failureUrl("/loginfail")
                .permitAll()
                .and()
                .httpBasic()
//                .usernameParameter("user")
//                .passwordParameter("passwordPaaar")
//                .loginProcessingUrl("/login")
//                .loginPage("/user/list")
//                .failureUrl("/security/loginfail")

//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/user")
                .and()
                .csrf().disable();
    }
}
