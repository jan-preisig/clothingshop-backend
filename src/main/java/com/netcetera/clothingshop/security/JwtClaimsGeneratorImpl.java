package com.netcetera.clothingshop.security;

import com.netcetera.clothingshop.domain.User;
import com.netcetera.security.jwt.JwtClaimsGenerator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtClaimsGeneratorImpl implements JwtClaimsGenerator {

    @Override
    public UserDetails createUserDetails(Claims claims) {
        return User.builder()
                .username(claims.getSubject())
                .firstName(claims.get("firstName", String.class))
                .lastName(claims.get("lastName", String.class))
//      .demo(claims.get("demo", Boolean.class))
                .build();
    }

    @Override
    public Claims createClaims(UserDetails userDetails) {
        User user = (User) userDetails;
        Claims claims = Jwts.claims();
        claims.setSubject(user.getUsername());
        claims.put("firstName", user.getFirstName());
        claims.put("lastName", user.getLastName());
//    claims.put("demo", user.isAdmin());
        return claims;
    }

}
