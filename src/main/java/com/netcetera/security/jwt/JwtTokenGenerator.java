package com.netcetera.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
public class JwtTokenGenerator {

  private String secret;
  private JwtClaimsGenerator claimsGenerator;

  public UserDetails parseToken(String token) {
    try {
      Claims claims = Jwts.parser()
        .setSigningKey(secret.getBytes())
        .parseClaimsJws(token)
        .getBody();

      return claimsGenerator.createUserDetails(claims);
    } catch (JwtException | ClassCastException e) {
      return null;
    }
  }

  public String generateToken(UserDetails user) {
    Claims claims = claimsGenerator.createClaims(user);

    return Jwts.builder()
      .setClaims(claims)
      .signWith(SignatureAlgorithm.HS512, secret.getBytes())
      .compact();
  }
}
