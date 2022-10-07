package br.edu.ifsp.circulosolidario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.circulosolidario.model.Documento;
import br.edu.ifsp.circulosolidario.repository.DocumentoRepository;

@RestController
@CrossOrigin

public class DocumentoController {
    @Autowired
    DocumentoRepository repo;

    @GetMapping("/documento")
    public List<Documento> recuperaDocumentos(){
        return (List<Documento>) repo.findAll();
    }

    @PostMapping("/documento")
    public void salvaDocumentos(@RequestBody Documento documento){
        repo.save(documento);
    }
}