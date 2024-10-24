
package com.example.checkpoint02_java_hotel.service;

import com.example.checkpoint02_java_hotel.dto.HotelDTO;
import com.example.checkpoint02_java_hotel.model.Hotel;
import com.example.checkpoint02_java_hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel save(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setNome(hotelDTO.getNome());
        hotel.setEndereco(hotelDTO.getEndereco());
        return hotelRepository.save(hotel);
    }

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public void deleteById(Long id) {
        hotelRepository.deleteById(id);
    }
}




