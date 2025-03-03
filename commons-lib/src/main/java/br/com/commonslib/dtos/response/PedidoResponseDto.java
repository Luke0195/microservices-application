package br.com.commonslib.dtos.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoResponseDto(
        Long id,
        String nome,
        String email,
        Long produto,
        BigDecimal valor,
        @JsonProperty("data_compra")
        LocalDate dataCompra,
        @JsonProperty("cpf_cliente")
        String cpfCliente,
        @JsonProperty("cep_cliente")
        String cepCliente) {

}
