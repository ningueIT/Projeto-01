package com.br.var.solutions.adapters.input.controllers;

import com.br.var.solutions.adapters.input.entitiles.GenerateToken;
import com.br.var.solutions.application.entities.ValidaUsuario;
import com.br.var.solutions.infraestructure.config.security.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //avisando que ela é uma controler
@RequestMapping("/auth") // é a rota que ela está
@CrossOrigin(origins = "*") // leberando qualquer tipo de chamada para essa rota especifica
@Slf4j //é a nossa anotação para conseguir criar logs
public class AuthenticateController {

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<GenerateToken> generateToken(@RequestParam("client_id") String clientId,
                                                       @RequestParam("password") String password) {

        log.info("Iniciando a tentativa de geração de token para o usuário: " + clientId);

        Boolean validaUsuario = ValidaUsuario.validaUsuario(clientId, password);

        if (Boolean.FALSE.equals(validaUsuario)) {
            log.error("não foi possivel gerar o token pois tem algo de arrado.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GenerateToken());
        }

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

        String token =jwtTokenUtil.generateToken(clientId);

        GenerateToken tokenResponse = new GenerateToken();
        tokenResponse.setToken(token);

        log.info("token gerado com sucesso para o usuario: " + clientId + "Em: " + System.currentTimeMillis());

        return ResponseEntity.ok(tokenResponse);
    }
}
