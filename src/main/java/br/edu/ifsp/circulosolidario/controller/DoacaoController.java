package br.edu.ifsp.circulosolidario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.circulosolidario.model.Doacao;
import br.edu.ifsp.circulosolidario.repository.DoacaoRepository;

@RestController
@CrossOrigin

public class DoacaoController {
    @Autowired
    DoacaoRepository repo;

    @GetMapping("/doacao")
    public List<Doacao> recuperaDoacoes(){
        return (List<Doacao>)repo.findAll();
    }

    @PostMapping("/doacao")
    public void salvaDoacoes(@RequestBody Doacao doacao){
        repo.save(doacao);
    }
}