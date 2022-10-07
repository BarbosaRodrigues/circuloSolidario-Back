package br.edu.ifsp.circulosolidario.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifsp.circulosolidario.model.Documento;

public interface DocumentoRepository extends CrudRepository<Documento, Long>{}