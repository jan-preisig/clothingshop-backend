package com.netcetera.security.jwt;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

  private JwtTokenGenerator jwtTokenGenerator;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
    String token = jwtAuthenticationToken.getToken();

    UserDetails user = jwtTokenGenerator.parseToken(token);
    if (user == null) {
      throw new JwtException("JWT token is not valid");
    }

    jwtAuthenticationToken.setDetails(user);
    return jwtAuthenticationToken;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
  }

}
