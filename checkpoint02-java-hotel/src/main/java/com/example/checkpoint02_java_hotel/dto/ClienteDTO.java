package com.example.checkpoint02_java_hotel.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {

    @NotBlank(message = "O nome não pode estar vazio.")
    private String nome;

    @Email(message = "Email deve ser válido.")
    @NotBlank(message = "O email não pode estar vazio.")
    private String email;

    @NotBlank(message = "O documento não pode estar vazio.")
    private String documento;


    public ClienteDTO() {}

    public ClienteDTO(String nome, String email, String documento) {
        this.nome = nome;
        this.email = email;
        this.documento = documento;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}

