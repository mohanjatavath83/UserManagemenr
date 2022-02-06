package com.user.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil
{

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret.key}")
	private String secret;

	public String generateToken(String subject)
	{
		return Jwts.builder()
				.setSubject(subject)
				.setIssuer(this.secret)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public Claims getClaims(String token)
	{
		return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
	}

	public String getUserName(String token) {
		return getClaims(token).getSubject();
	}

	public Date getExpiryDate(String token) {
		return getClaims(token).getExpiration();
	}
	
	public boolean isTokenExiper(String token) {
		return new Date().after(getClaims(token).getExpiration());
	}
	
	public boolean validateToken(String userId, String token) {
		return userId.equalsIgnoreCase(getClaims(token).getSubject()) && !isTokenExiper(token);
	}

}
