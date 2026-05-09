package br.com.pferreira.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * @author Pedro Ferreira
 */

@Component
public class JwtService {

  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiration}")
  private Long expiration;

  public String gerarToken(String email, String role){
    return Jwts.builder()
            .subject(email)
            .claim("role", role)
            .issuedAt(new Date(System.currentTimeMillis() + expiration))
            .signWith(getKey())
            .compact();
  }

  public String extrairEmail(String token){
    return Jwts.parser()
            .verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
  }

  public String extrairRole(String token){
    return Jwts.parser()
            .verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .get("role", String.class);
  }

  public boolean tokenValido(String token){
    try {
      Jwts.parser()
              .verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
              .build()
              .parseSignedClaims(token);
      return true;
    }catch (Exception e){
      return false;
    }
  }

  private Key getKey(){
    return Keys.hmacShaKeyFor(secret.getBytes());
  }
}
