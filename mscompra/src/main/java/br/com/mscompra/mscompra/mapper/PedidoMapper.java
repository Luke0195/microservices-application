package br.com.mscompra.mscompra.mapper;


import br.com.commonslib.dtos.request.PedidoRequestDto;

import br.com.commonslib.dtos.response.PedidoResponseDto;
import br.com.mscompra.mscompra.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    @Mapping(target = "id", ignore = true)
    Pedido pedidoRequestDtoToPedido(PedidoRequestDto pedidoRequestDto);

    PedidoResponseDto pedidoToPedidoResponseDto(Pedido pedido);
}
