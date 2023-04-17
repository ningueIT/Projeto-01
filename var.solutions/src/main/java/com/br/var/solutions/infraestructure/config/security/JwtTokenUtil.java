package com.br.var.solutions.infraestructure.config.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
    private static long serialVersionUID = -2550185165626007488L;

    private static long JWT_TOKEN_EXPIRES = 1800000;

    private String secret = "8a4277f6229ee9d97cf9553c5f3dfac376045805f018c92fffc5f88ef8119b430d22e269c7ac2781716220b97899f031bec206a968fb25d9481417d120f2844b";

    //retonar o usuario do token do jwt
    public String getUsernameFromToken(String token) {
        return getClainFromToken(token, Claims::getSubject);
    }

    //Retorna vários objetos possiveis de várias tipos possíveis. - captura as informções de dentro do token
    public <T> T getClainFromToken(String token, Function<Claims, T> clainsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return clainsResolver.apply(claims);
    }

    //retorna expiration date do token jwt
    public Date getExpirationDatefromToken(String token) {
        return getClainFromToken(token, Claims::getExpiration);
    }

    //para retornar qualquer informação do token, e para isso nós vamos precisar da secret.
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    //validar se o token é expirado
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDatefromToken(token);
        return expiration.before(new Date());
    }

    //Gerar Token
    public String generateToken(String clientId) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, clientId);
    }

    //Cria o token e também vai definir o tempo de expiração.
    private String doGenerateToken(Map <String, Object> claims, String clientId) {
        return Jwts.builder().setClaims(claims).setSubject(clientId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_EXPIRES))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    //valida o token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }



}