package br.com.uniamerica.lembrete.Dto;

import br.com.uniamerica.lembrete.Entidade.Pessoa;

public class LembreteDTO {
    private Long id;
    private String anotacoes;
    private Pessoa pessoa;

    public LembreteDTO() {}

    public LembreteDTO(Long id, String anotacoes, br.com.uniamerica.lembrete.Entidade.Pessoa pessoa) {
        this.id = id;
        this.anotacoes = anotacoes;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}