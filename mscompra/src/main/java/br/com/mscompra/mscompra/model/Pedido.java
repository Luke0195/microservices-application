package br.com.mscompra.mscompra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="tb_pedidos")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Long produto;
    private BigDecimal valor;
    @Column(name = "data_compra")
    private LocalDate dataCompra;
    @Column(name="cpf_cliente")
    private String cpfCliente;
    @Column(name="cep_cliente")
    private String cepCliente;
}
