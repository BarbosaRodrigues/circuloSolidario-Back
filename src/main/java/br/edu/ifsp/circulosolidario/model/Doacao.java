package br.edu.ifsp.circulosolidario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String data, hora, descricaoItem, statusDoacao;
    private int unidadeItem, quantidadeItem;

    public Doacao(){}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public String getDescricaoItem() {
        return descricaoItem;
    }
    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }
    public String getStatusDoacao() {
        return statusDoacao;
    }
    public void setStatusDoacao(String statusDoacao) {
        this.statusDoacao = statusDoacao;
    }
    public int getUnidadeItem() {
        return unidadeItem;
    }
    public void setUnidadeItem(int unidadeItem) {
        this.unidadeItem = unidadeItem;
    }
    public int getQuantidadeItem() {
        return quantidadeItem;
    }
    public void setQuantidadeItem(int quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }
}
    
    
