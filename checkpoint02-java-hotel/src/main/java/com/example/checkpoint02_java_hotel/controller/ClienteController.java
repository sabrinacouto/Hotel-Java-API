package com.example.checkpoint02_java_hotel.controller;

import com.example.checkpoint02_java_hotel.dto.ClienteDTO;
import com.example.checkpoint02_java_hotel.model.Cliente;
import com.example.checkpoint02_java_hotel.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente novoCliente = clienteService.save(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteDTO> clienteDTOS = clientes.stream()
                .map(cliente -> new ClienteDTO(cliente.getNome(), cliente.getEmail(), cliente.getDocumento()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(clienteDTOS);
    }
}

