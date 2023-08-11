package br.com.uniamerica.lembrete.Dto;

import br.com.uniamerica.lembrete.Entidade.Lembrete;

import java.util.List;

public class PessoaDTO {
    private Long id;
    private String nome;
    List<Lembrete> lembretes;

    public PessoaDTO(){}

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }

    public PessoaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

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
}