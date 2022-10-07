package br.edu.ifsp.circulosolidario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.circulosolidario.model.Doador;
import br.edu.ifsp.circulosolidario.repository.DoadorRepository;

@RestController
@CrossOrigin

public class DoadorController {
    @Autowired
    DoadorRepository repo;

    @GetMapping("/doador")
    public List<Doador> recuperaDoadores(){
        return (List<Doador>)repo.findAll();
    }

    @PostMapping("/doador")
    public void salvaDoadores(@RequestBody Doador doador){
        repo.save(doador);
    }
}