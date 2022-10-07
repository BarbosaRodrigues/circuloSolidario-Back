package br.edu.ifsp.circulosolidario.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Instituicao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome, cnpj, senha, endereco, endereco2, cidade, estado, diasSemanais;
    private int horario, horario2, horario3;
    @ManyToMany(mappedBy="instituicoes")
    @JsonBackReference
    private List<Doador> doadores;

    public Instituicao(){}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEndereco2() {
        return endereco2;
    }
    public void setEndereco2(String endereco2) {
        this.endereco2 = endereco2;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getDiasSemanais() {
        return diasSemanais;
    }
    public void setDiasSemanais(String diasSemanais) {
        this.diasSemanais = diasSemanais;
    }
    public int getHorario() {
        return horario;
    }
    public void setHorario(int horario) {
        this.horario = horario;
    }
    public int getHorario2() {
        return horario2;
    }
    public void setHorario2(int horario2) {
        this.horario2 = horario2;
    }
    public int getHorario3() {
        return horario3;
    }
    public void setHorario3(int horario3) {
        this.horario3 = horario3;
    }

    public List<Doador> getDoadores() {
        return doadores;
    }

    public void setDoadores(List<Doador> doadores) {
        this.doadores = doadores;
    }
    
}
