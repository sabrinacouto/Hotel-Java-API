package com.example.checkpoint02_java_hotel.controller;


import com.example.checkpoint02_java_hotel.dto.PedidoServicoDTO;
import com.example.checkpoint02_java_hotel.service.PedidoServicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos-servico")
public class PedidoServicoController {

    private final PedidoServicoService pedidoServicoService;

    public PedidoServicoController(PedidoServicoService pedidoServicoService) {
        this.pedidoServicoService = pedidoServicoService;
    }

    @GetMapping
    public ResponseEntity<List<PedidoServicoDTO>> listarTodos() {
        return ResponseEntity.ok(pedidoServicoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<PedidoServicoDTO> criarPedido(@Valid @RequestBody PedidoServicoDTO dto) {
        PedidoServicoDTO novoPedido = pedidoServicoService.criarPedido(dto);
        return ResponseEntity.ok(novoPedido);
    }
}

