package com.example.checkpoint02_java_hotel.repository;

import com.example.checkpoint02_java_hotel.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("SELECT r FROM Reserva r WHERE r.cliente.id = :clienteId AND r.dataCheckIn >= :dataInicial AND r.dataCheckOut <= :dataFinal")
    List<Reserva> findByClienteAndPeriodo(@Param("clienteId") Long clienteId,
                                          @Param("dataInicial") LocalDate dataInicial,
                                          @Param("dataFinal") LocalDate dataFinal);
}

