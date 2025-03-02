package br.com.mscompra.mscompra.controller;

import br.com.commonslib.dtos.request.PedidoRequestDto;
import br.com.commonslib.dtos.response.PedidoResponseDto;
import br.com.mscompra.mscompra.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    private final PedidoService pedidoService;


    @PostMapping
    public ResponseEntity<PedidoResponseDto> salvarPedido(@Valid  @RequestBody PedidoRequestDto pedidoRequestDto){
        PedidoResponseDto pedidoResponseDto = pedidoService.salvarPedido(pedidoRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoResponseDto);
    }
}
