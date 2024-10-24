package com.example.checkpoint02_java_hotel.controller;

import com.example.checkpoint02_java_hotel.dto.QuartoDTO;
import com.example.checkpoint02_java_hotel.model.Quarto;
import com.example.checkpoint02_java_hotel.service.QuartoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {

    private final QuartoService quartoService;

    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @PostMapping("/{hotelId}")
    public ResponseEntity<String> createQuarto(@PathVariable Long hotelId, @Valid @RequestBody QuartoDTO quartoDTO) {
        return quartoService.createQuarto(quartoDTO, hotelId);
    }
    @GetMapping
    public List<Quarto> getAllQuartos() {
        return quartoService.getQuartos();
    }

    @GetMapping("/hotel/{hotelId}")
    public List<Quarto> getQuartosByHotel(@PathVariable Long hotelId, @RequestParam(required = false) String tipo) {
        return quartoService.getQuartosByHotelAndTipo(hotelId, tipo);
    }

    @GetMapping("/disponiveis")
    public List<Quarto> getQuartosDisponiveis(@RequestParam LocalDate dataEntrada, @RequestParam LocalDate dataSaida) {
        return quartoService.getQuartosDisponiveis(dataEntrada, dataSaida);
    }
}



