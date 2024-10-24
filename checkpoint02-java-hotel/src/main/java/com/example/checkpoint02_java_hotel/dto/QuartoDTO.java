package com.example.checkpoint02_java_hotel.dto;

import jakarta.validation.constraints.NotBlank;

public class QuartoDTO {

    private Long id;

    @NotBlank(message = "Número é obrigatório")
    private String numero;

    @NotBlank(message = "Tipo é obrigatório")
    private String tipo;

    private Long hotelId;

    public QuartoDTO() {}

    public QuartoDTO(Long id, String numero, String tipo, Long hotelId) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.hotelId = hotelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
}

