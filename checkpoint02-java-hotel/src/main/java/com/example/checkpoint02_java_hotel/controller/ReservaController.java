package com.example.checkpoint02_java_hotel.controller;

import com.example.checkpoint02_java_hotel.model.Reserva;
import com.example.checkpoint02_java_hotel.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> createReserva(@Valid @RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.createReserva(reserva);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> getReservas(@RequestParam Long clienteId,
                                                     @RequestParam LocalDate dataInicial,
                                                     @RequestParam LocalDate dataFinal) {
        List<Reserva> reservas = reservaService.getReservasByClienteAndPeriodo(clienteId, dataInicial, dataFinal);
        return ResponseEntity.ok(reservas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelReserva(@PathVariable Long id) {
        reservaService.cancelReserva(id);
        return ResponseEntity.noContent().build();
    }
}

