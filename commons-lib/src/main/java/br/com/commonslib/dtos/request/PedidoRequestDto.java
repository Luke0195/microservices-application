package br.com.commonslib.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoRequestDto(
        @NotEmpty(message = "O campo nome é obrigatório.")
        String nome,
        @NotNull(message = "O campo produto é obrigatório.")
        @Min(value = 1, message = "O campo produto não pode ser negativo.")
        Long produto,
        @NotEmpty(message = "O campo e-mail é obrigatório")
        @Email(message = "O campo e-mail é obrigatório")
        String email,
        @NotNull(message = "O campo valor é obrigatório")
        BigDecimal valor,
        @NotNull(message = "O campo data_compra é obrigatório")
        @JsonProperty("data_compra")
        LocalDate dataCompra,
        @JsonProperty("cpf_cliente")
        @CPF(message = "Informe um cpf valido")
        @NotEmpty(message = "O campo cpf é obrigatório")
        String cpfCliente,
        @NotEmpty(message = "O campo cep é obrigatório")
        @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$", message = "Informe um cep valido!")
        @JsonProperty("cep_cliente")
        String cepCliente
) {
}
