package com.netcetera.security.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtClaimsGenerator {

  UserDetails createUserDetails(Claims claims);

  Claims createClaims(UserDetails user);

}
