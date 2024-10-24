package com.example.checkpoint02_java_hotel.controller;


import com.example.checkpoint02_java_hotel.dto.ServicoDTO;
import com.example.checkpoint02_java_hotel.model.Servico;
import com.example.checkpoint02_java_hotel.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    // Método para cadastrar um novo serviço
    @PostMapping
    public ResponseEntity<ServicoDTO> createServico(@Valid @RequestBody ServicoDTO servicoDTO) {
        Servico novoServico = new Servico();
        novoServico.setNome(servicoDTO.getNome());
        novoServico.setDescricao(servicoDTO.getDescricao());
        novoServico.setPreco(servicoDTO.getPreco()); // Aqui já é BigDecimal

        Servico savedServico = servicoService.createServico(novoServico);

        ServicoDTO responseDto = new ServicoDTO();
        responseDto.setId(savedServico.getId());
        responseDto.setNome(savedServico.getNome());
        responseDto.setDescricao(savedServico.getDescricao());
        responseDto.setPreco(savedServico.getPreco()); // Aqui já é BigDecimal

        return ResponseEntity.status(201).body(responseDto);
    }

    // Método para listar todos os serviços
    @GetMapping
    public List<ServicoDTO> getAllServicos() {
        return servicoService.getAllServicos()
                .stream()
                .map(servico -> {
                    ServicoDTO dto = new ServicoDTO();
                    dto.setId(servico.getId());
                    dto.setNome(servico.getNome());
                    dto.setDescricao(servico.getDescricao());
                    dto.setPreco(servico.getPreco()); // Aqui já é BigDecimal
                    return dto;
                })
                .collect(Collectors.toList());
    }
}




