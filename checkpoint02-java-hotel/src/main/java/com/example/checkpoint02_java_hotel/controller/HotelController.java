package com.example.checkpoint02_java_hotel.controller;


import com.example.checkpoint02_java_hotel.dto.HotelDTO;
import com.example.checkpoint02_java_hotel.model.Hotel;
import com.example.checkpoint02_java_hotel.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoteis")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@Valid @RequestBody HotelDTO hotelDTO) {
        Hotel novoHotel = hotelService.save(hotelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoHotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHoteis() {
        List<Hotel> hoteis = hotelService.findAll();
        return ResponseEntity.ok(hoteis);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


