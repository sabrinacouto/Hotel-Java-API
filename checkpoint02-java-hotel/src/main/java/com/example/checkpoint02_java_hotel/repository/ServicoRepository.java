package com.example.checkpoint02_java_hotel.repository;


import com.example.checkpoint02_java_hotel.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}


