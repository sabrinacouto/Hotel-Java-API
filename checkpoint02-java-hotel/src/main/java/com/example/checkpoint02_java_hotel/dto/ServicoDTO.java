package com.example.checkpoint02_java_hotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ServicoDTO {

    private Long id;

    @NotBlank(message = "O nome do serviço é obrigatório.")
    private String nome;

    private String descricao;

    @NotNull(message = "O preço do serviço é obrigatório.")
    private BigDecimal preco; // Alterado para BigDecimal

    // Getters e Setters

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() { // Alterado para BigDecimal
        return preco;
    }

    public void setPreco(BigDecimal preco) { // Alterado para BigDecimal
        this.preco = preco;
    }
}


