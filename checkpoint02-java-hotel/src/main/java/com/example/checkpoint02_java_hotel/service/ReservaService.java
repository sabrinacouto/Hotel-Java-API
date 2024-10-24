package com.example.checkpoint02_java_hotel.service;

import com.example.checkpoint02_java_hotel.exception.ReservaException;
import com.example.checkpoint02_java_hotel.model.Reserva;
import com.example.checkpoint02_java_hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva createReserva(Reserva reserva) {
        if (reserva.getDataCheckOut().isBefore(reserva.getDataCheckIn())) {
            throw new ReservaException("A data de Check-out deve ser após a data de Check-in");
        }
        return reservaRepository.save(reserva);
    }

    public List<Reserva> getReservasByClienteAndPeriodo(Long clienteId, LocalDate dataInicial, LocalDate dataFinal) {
        return reservaRepository.findByClienteAndPeriodo(clienteId, dataInicial, dataFinal);
    }

    public void cancelReserva(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new ReservaException("Reserva não encontrada");
        }
        reservaRepository.deleteById(id);
    }
}







