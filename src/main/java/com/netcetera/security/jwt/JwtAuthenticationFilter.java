package com.netcetera.security.jwt;

import com.netcetera.rest.WebServiceUrl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

  private static final String AuthorizationHeaderFieldName = "Authorization";
  private static final String AuthorizationPrefix = "Bearer";

  public JwtAuthenticationFilter(AuthenticationManager authenticationManager, AuthenticationSuccessHandler authenticationSuccessHandler) {
    super(WebServiceUrl.Prefix + "/**");
    this.setAuthenticationManager(authenticationManager);
    this.setAuthenticationSuccessHandler(authenticationSuccessHandler);
  }

  @Override
  protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
    String header = request.getHeader(AuthorizationHeaderFieldName);
    return header != null && header.contains(AuthorizationPrefix);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    String header = request.getHeader(AuthorizationHeaderFieldName);
    if (header == null) {
      throw new JwtException("Authorization header field missing");
    }

    String[] values = header.split(",");
    Optional<String> token = Arrays.stream(values).map(String::trim).filter(value -> value.startsWith(AuthorizationPrefix)).findFirst();
    if (!token.isPresent()) {
      throw new JwtException("Authorization header field must contain a Bearer token");
    }

    String authToken = token.get().trim().substring(6).trim();
    JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);
    return getAuthenticationManager().authenticate(authRequest);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
    throws IOException, ServletException {
    super.successfulAuthentication(request, response, chain, authResult);
    chain.doFilter(request, response);
  }
}
