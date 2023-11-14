package com.senai.mamuka.apimamuka.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.senai.mamuka.apimamuka.models.UsuariosModel;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(UsuariosModel usuario) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("apimamuka")
                    .withSubject(usuario.getEmail())
                    .withClaim("nomeUsuario", usuario.getNome())
                    .withExpiresAt(gerarValidadeToken())
                    .sign(algoritmo);

            return token;
        } catch(JWTCreationException exception) {
            throw new RuntimeException("Erro na criação do token: ", exception);
        }
    }

    public String validarToken(String token) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);

            return JWT.require(algoritmo)
                    .withIssuer("apimamuka")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch(JWTCreationException exception) {
            return "";
        }
    }

    public Instant gerarValidadeToken() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}