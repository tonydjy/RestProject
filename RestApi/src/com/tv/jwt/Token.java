package com.tv.jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;

import java.util.Date;

public class Token {
	  private static Key key = MacProvider.generateKey();
	  private static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256 ;
	  public static String createJWT(String name, String role, long ttlMillis) throws Exception {

	       System.out.println("encode key is : " + key);
	       long nowMillis = System. currentTimeMillis();
	       Date now = new Date(nowMillis);
	       JwtBuilder builder = Jwts.builder()
	            .setIssuedAt(now)
	            .setId(name)
	            .setSubject(role)
	           .signWith(signatureAlgorithm, key);
	       if (ttlMillis >= 0){
	           long expMillis = nowMillis + ttlMillis;
	           Date exp = new Date( expMillis);
	           builder.setExpiration( exp);
	       }
	       return builder.compact();
	 }
	  
	  public static boolean parseJWT(String jwt, String subject) {
		  try{
			  Claims claims = Jwts. parser()
	          .setSigningKey(key)
	          .parseClaimsJws(jwt).getBody();
			  //check role
			  if(claims.get("sub").toString().equals(subject) ){
				  return true;
			  }
		  }catch(io.jsonwebtoken.ExpiredJwtException e){
			  System.out.println("token expired! ");
			  return false;
		  }catch(io.jsonwebtoken.SignatureException e){
			  System.out.println("wrong signature! ");
			  return false;
		  }
		  return false;

	 }
	  
	  public static void main(String[] args) throws Exception{

		  String token = Token.createJWT("test", "tony", 10000); 
		  Key key = MacProvider.generateKey();
		  System.out.println("parse key is : " + key);
		  //Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
		  boolean bo = Token.parseJWT(token, "tony");
		  System.out.println(bo);
	  }
}
