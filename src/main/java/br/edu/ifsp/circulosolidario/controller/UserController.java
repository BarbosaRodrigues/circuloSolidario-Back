package br.edu.ifsp.circulosolidario.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.circulosolidario.model.Doador;
import br.edu.ifsp.circulosolidario.repository.DoadorRepository;
import br.edu.ifsp.circulosolidario.security.jwt.JwtUtils;
import io.jsonwebtoken.Header;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    DoadorRepository doadorRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody Doador doadorNovo){
        // Se encontrar no banco, não poderá criar um novo usuário
        boolean exists = doadorRepository.findByEmail(doadorNovo.getEmail()).stream().count() > 0;
        // Mas não existir, cra o novo usuário no banco
        if(!exists){
            //criptografa a senha do usuário para por no banco de dados
            doadorNovo.setSenha(
                passwordEncoder.encode(doadorNovo.getSenha())
            );
            doadorRepository.save(doadorNovo);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();    
    }

    @GetMapping("/user")
    public List<Doador> getAllUsers(){
        return (List<Doador>)doadorRepository.findAll();
    }
    
    @GetMapping("/user/me")
    public Doador getMyInformations(@RequestHeader("Authorization") String token){
        // String token = headers.firstValue("Authorization").get();
        System.out.println(token);
        token = token.substring(7, token.length());
        String email = jwtUtils.getUserNameFromJwtToken(token);
        return doadorRepository.findByEmail(email).get(0);
    }
}
