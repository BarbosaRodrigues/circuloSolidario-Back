package br.edu.ifsp.circulosolidario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.circulosolidario.model.Instituicao;
import br.edu.ifsp.circulosolidario.repository.InstituicaoRepository;

@RestController
@CrossOrigin

public class InstituicaoController {
    @Autowired
    InstituicaoRepository repo;

    @GetMapping("/instituicao")
    public List<Instituicao> recuperaInstituicoes(){
        return (List<Instituicao>)repo.findAll();
    }

    @PostMapping("/instituicao")
    public void salvaInstituicoes(@RequestBody Instituicao instituicao){
        repo.save(instituicao);
    }
}