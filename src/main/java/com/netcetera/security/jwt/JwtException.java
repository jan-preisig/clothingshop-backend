package com.netcetera.security.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtException extends AuthenticationException {

  public JwtException(String msg) {
    super(msg);
  }

  public JwtException(String msg, Throwable t) {
    super(msg, t);
  }

}
