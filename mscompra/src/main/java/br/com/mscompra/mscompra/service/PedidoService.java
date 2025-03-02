package br.com.mscompra.mscompra.service;

import br.com.commonslib.dtos.request.PedidoRequestDto;
import br.com.commonslib.dtos.response.PedidoResponseDto;
import br.com.mscompra.mscompra.mapper.PedidoMapper;
import br.com.mscompra.mscompra.model.Pedido;
import br.com.mscompra.mscompra.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Transactional
    public PedidoResponseDto salvarPedido(PedidoRequestDto pedidoRequestDto){
      Pedido pedido = PedidoMapper.INSTANCE.pedidoRequestDtoToPedido(pedidoRequestDto);
      pedido = pedidoRepository.save(pedido);
      return PedidoMapper.INSTANCE.pedidoToPedidoResponseDto(pedido);
    }
}
