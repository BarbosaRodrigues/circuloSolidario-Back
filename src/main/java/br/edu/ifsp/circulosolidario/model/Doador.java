package br.edu.ifsp.circulosolidario.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Doador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome, email, senha;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_documento")
    private Documento documento;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_itensDoacao")
    // @JsonManagedReference
    private List<ItensDoacao> ItensDoacao;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="associacao_doador_instituicao", joinColumns=@JoinColumn(name="fk_doador"), inverseJoinColumns = @JoinColumn(name = "fk_instituicao"))
    // @JsonManagedReference
    private List<Instituicao> instituicoes;


    public Doador() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Documento getDocumento() {
        return documento;
    }
    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public List<ItensDoacao> getItensDoacao() {
        return ItensDoacao;
    }

    public void setItensDoacao(List<ItensDoacao> itensDoacao) {
        ItensDoacao = itensDoacao;
    }

    public List<Instituicao> getInstituicoes() {
        return instituicoes;
    }

    public void setInstituicoes(List<Instituicao> instituicoes) {
        this.instituicoes = instituicoes;
    }
    

}
