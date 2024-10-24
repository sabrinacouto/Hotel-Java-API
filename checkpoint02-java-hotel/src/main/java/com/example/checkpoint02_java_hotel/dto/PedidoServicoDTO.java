package com.example.checkpoint02_java_hotel.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PedidoServicoDTO {

    private Long id;

    @NotNull
    private LocalDateTime dataPedido;

    @NotNull
    private Long reservaId;

    @NotNull
    private Long servicoId;

    public PedidoServicoDTO() {}

    public PedidoServicoDTO(Long id, LocalDateTime dataPedido, Long reservaId, Long servicoId) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.reservaId = reservaId;
        this.servicoId = servicoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }
}

