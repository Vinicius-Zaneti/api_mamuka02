package com.senai.mamuka.apimamuka.controllers;

import com.senai.mamuka.apimamuka.dtos.LoginDto;
import com.senai.mamuka.apimamuka.dtos.TokenDto;
import com.senai.mamuka.apimamuka.models.UsuariosModel;
import com.senai.mamuka.apimamuka.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto dados) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());

        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.gerarToken( (UsuariosModel) auth.getPrincipal() );

        return ResponseEntity.status(HttpStatus.OK).body(new TokenDto(token));
    }
}
