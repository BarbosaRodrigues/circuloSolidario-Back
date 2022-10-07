package br.edu.ifsp.circulosolidario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.circulosolidario.model.ItensDoacao;
import br.edu.ifsp.circulosolidario.repository.ItensDoacaoRepository;

@RestController
@CrossOrigin

public class ItensDoacaoController {
    @Autowired
    ItensDoacaoRepository repo;

    @GetMapping("/itensDoacao")
    public List<ItensDoacao> recuperaItensDoacoes(){
        return (List<ItensDoacao>)repo.findAll();
    }

    @PostMapping("/itensDoacao")
    public void salvaItensDoacoes(@RequestBody ItensDoacao itensDoacao){
        repo.save(itensDoacao);
    }
}