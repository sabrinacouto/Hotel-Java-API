package com.example.checkpoint02_java_hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Data de Check-in é obrigatória")
    private LocalDate dataCheckIn;

    @NotNull(message = "Data de Check-out é obrigatória")
    @Future(message = "Data de Check-out deve ser futura")
    private LocalDate dataCheckOut;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "reserva_quarto",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "quarto_id"))
    private Set<Quarto> quartos = new HashSet<>();

    // Construtores
    public Reserva() {
    }

    public Reserva(LocalDate dataCheckIn, LocalDate dataCheckOut, Cliente cliente) {
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.cliente = cliente;
    }

    // Métodos auxiliares para gerenciar quartos
    public void addQuarto(Quarto quarto) {
        this.quartos.add(quarto);
        quarto.getReservas().add(this); // Manter a bidirecionalidade
    }

    public void removeQuarto(Quarto quarto) {
        this.quartos.remove(quarto);
        quarto.getReservas().remove(this); // Manter a bidirecionalidade
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(LocalDate dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(LocalDate dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(Set<Quarto> quartos) {
        this.quartos = quartos;
    }
}



