package com.senai.mamuka.apimamuka.controllers;


import com.senai.mamuka.apimamuka.dtos.UsuariosDto;
import com.senai.mamuka.apimamuka.models.UsuariosModel;
import com.senai.mamuka.apimamuka.repositories.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/usuarios", produces = {"application/json"})
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuariosModel>> listarUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
    }
    @GetMapping("/{idUsuario}")
    public ResponseEntity<Object> exibirUsuario(@PathVariable(value = "idUsuario") UUID id) {
        Optional<UsuariosModel> usuarioBuscado = usuarioRepository.findById(id);

        if (usuarioBuscado.isEmpty()) {
            // Retornar usuario não encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarioBuscado.get());
    }

    @PostMapping
    @Operation(summary = "Método para criar um usuário", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cadastro de Usuário feito com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos")
    })
    public ResponseEntity<Object> cadastrarUsuario(@RequestBody @Valid UsuariosDto usuarioDto) {
        if (usuarioRepository.findByEmail(usuarioDto.email()) != null) {
            // Não pode cadastrar
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esse email já está cadastrado!");
        }
        UsuariosModel usuario = new UsuariosModel();
        BeanUtils.copyProperties(usuarioDto, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));



        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioDto.senha());
        usuario.setSenha(senhaCriptografada);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Object> editarUsuario(@PathVariable(value = "idUsuario") UUID id, @RequestBody @Valid UsuariosDto usuarioDto) {
        Optional<UsuariosModel> usuarioBuscado = usuarioRepository.findById(id);

        if (usuarioBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }

        UsuariosModel usuario = new UsuariosModel();

        BeanUtils.copyProperties(usuarioDto, usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioDto.senha());
        usuario.setSenha(senhaCriptografada);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable(value = "idUsuario") UUID id) {
        Optional<UsuariosModel> usuarioBuscado = usuarioRepository.findById(id);

        if (usuarioBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }

        usuarioRepository.delete(usuarioBuscado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario deletado com sucesso!");
    }
}
