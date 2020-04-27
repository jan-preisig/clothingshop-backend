package com.netcetera.security.jwt;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

@Getter
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

  private String token;

  public JwtAuthenticationToken(String token) {
    super(null);
    this.token = token;
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return getDetails();
  }
}
