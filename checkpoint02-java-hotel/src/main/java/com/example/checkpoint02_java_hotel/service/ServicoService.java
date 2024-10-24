package com.example.checkpoint02_java_hotel.service;


import com.example.checkpoint02_java_hotel.exception.ResourceNotFoundException;
import com.example.checkpoint02_java_hotel.model.Servico;
import com.example.checkpoint02_java_hotel.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public List<Servico> getAllServicos() {
        return servicoRepository.findAll();
    }

    public Servico createServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public Servico getServicoById(Long id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Serviço não encontrado com o ID: " + id));
    }
}


