package com.netcetera.clothingshop.config;

import com.netcetera.rest.WebServiceUrl;
import com.netcetera.security.jwt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.OPTIONS;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${password.secret}")
  private String passwordSecret;

  @Value("${jwt.secret}")
  private String jwtSecret;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private JwtClaimsGenerator jwtClaimsGenerator;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        .antMatchers(WebServiceUrl.Login).permitAll()
        .antMatchers(OPTIONS, WebServiceUrl.Prefix + "/**").permitAll()
        .anyRequest().permitAll()
        .and()
      .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
      .logout()
        .permitAll()
      .and().csrf().disable()
      .headers().frameOptions().disable();
  }

  @Bean
  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new StandardPasswordEncoder(passwordSecret);
  }

  @Bean
  public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
    return new JwtAuthenticationFilter(authenticationManager(), new JwtAuthenticationSuccessHandler());
  }

  @Bean
  public JwtTokenGenerator jwtTokenGenerator() {
    return new JwtTokenGenerator(jwtSecret, jwtClaimsGenerator);
  }

  @Bean
  public JwtAuthenticationProvider jwtAuthenticationProvider() {
    return new JwtAuthenticationProvider(jwtTokenGenerator());
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setPasswordEncoder(passwordEncoder());
    authProvider.setUserDetailsService(userDetailsService);
    return authProvider;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
    auth.authenticationProvider(jwtAuthenticationProvider());
  }

}
