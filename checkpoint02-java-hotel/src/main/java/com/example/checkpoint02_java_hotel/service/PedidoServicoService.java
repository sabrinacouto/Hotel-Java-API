package com.example.checkpoint02_java_hotel.service;


import com.example.checkpoint02_java_hotel.dto.PedidoServicoDTO;
import com.example.checkpoint02_java_hotel.exception.ResourceNotFoundException;
import com.example.checkpoint02_java_hotel.model.PedidoServico;
import com.example.checkpoint02_java_hotel.model.Reserva;
import com.example.checkpoint02_java_hotel.model.Servico;
import com.example.checkpoint02_java_hotel.repository.PedidoServicoRepository;
import com.example.checkpoint02_java_hotel.repository.ServicoRepository;
import com.example.checkpoint02_java_hotel.repository.ReservaRepository ;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServicoService {

    private final PedidoServicoRepository pedidoServicoRepository;
    private final ReservaRepository reservaRepository;
    private final ServicoRepository servicoRepository;

    public PedidoServicoService(PedidoServicoRepository pedidoServicoRepository,
                                ReservaRepository reservaRepository,
                                ServicoRepository servicoRepository) {
        this.pedidoServicoRepository = pedidoServicoRepository;
        this.reservaRepository = reservaRepository;
        this.servicoRepository = servicoRepository;
    }

    public List<PedidoServicoDTO> listarTodos() {
        return pedidoServicoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PedidoServicoDTO criarPedido(PedidoServicoDTO dto) {
        Reserva reserva = reservaRepository.findById(dto.getReservaId())
                .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrada."));
        Servico servico = servicoRepository.findById(dto.getServicoId())
                .orElseThrow(() -> new ResourceNotFoundException("Serviço não encontrado."));

        PedidoServico pedido = new PedidoServico(dto.getDataPedido(), reserva, servico);
        pedidoServicoRepository.save(pedido);

        return convertToDTO(pedido);
    }

    private PedidoServicoDTO convertToDTO(PedidoServico pedido) {
        return new PedidoServicoDTO(pedido.getId(), pedido.getDataPedido(),
                pedido.getReserva().getId(), pedido.getServico().getId());
    }
}

