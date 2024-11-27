package com.mcann.dumenflix.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class JwtManager {
	
	/**
	 * Token oluşturmak için gerekli parametreler :
	 * SecretKey -> Token imzalamak için gerekli şifre.
	 * Issuer -> jwt token sahibine ait bilgi.
	 * IssuerAt -> token üretilme zamanı.
	 * ExpiresAt -> token geçerlilik sona erme zamanı.
	 * Claim -> içerisinde KEY-VALUE şeklinde değer saklayan nesneler.
	 * NOT : Claim nesneleri içerisinde bulunan değerler açık olarak tutulur bu nedenle gizli kalması
	 * gerek değerleri buraya eklemeyiniz.
	 * Sign -> imzalama için kullanılır, mutlaka bir şifreleme algoritması vermek gerekir.
	 *
	 * [][] -> sadece rakam
	 */
	
	@Value("${dumenflix.jwt.secret-key}")
	private String secretKey;
	@Value("${dumenflix.jwt.issuer}")
	private String issuer;
	private final Long exDate=1000L*60*60; // 40 saniye sonra iptal olsun.
	
	public String createToken(Long authId){
		Date createdDate=new Date(System.currentTimeMillis());
		Date expirationDate=new Date(System.currentTimeMillis()+exDate);
		Algorithm algorithm=Algorithm.HMAC512(secretKey);
		String token = JWT.create()
				.withAudience()
				.withIssuer(issuer)
				.withIssuedAt(createdDate)
				.withExpiresAt(expirationDate)
				.withClaim("authId", authId)
				.withClaim("key","JX_15_TJJJ")
				.sign(algorithm);
		return token;
	}
	
	public Optional<Long> validateToken(String token){
		try{
			Algorithm algorithm=Algorithm.HMAC512(secretKey);
			JWTVerifier verifier=JWT.require(algorithm).build();
			DecodedJWT decodedJWT = verifier.verify(token);
			if (Objects.isNull(decodedJWT))
				return Optional.empty();
			Long authId = decodedJWT.getClaim("authId").asLong();
			return Optional.of(authId);
		}
		catch (Exception exception) {
			return Optional.empty();
		}
		
		
	}
}