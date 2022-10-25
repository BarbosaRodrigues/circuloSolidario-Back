package br.edu.ifsp.circulosolidario.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifsp.circulosolidario.model.Doador;

public interface DoadorRepository extends CrudRepository<Doador, Long>{
    List<Doador> findByEmail(String email);
}


