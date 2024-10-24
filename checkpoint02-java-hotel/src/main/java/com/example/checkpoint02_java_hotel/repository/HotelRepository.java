package com.example.checkpoint02_java_hotel.repository;

import com.example.checkpoint02_java_hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}

