package br.com.workercompras.model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Endereco implements Serializable {
   private String cep;
   private String logradouro;
   private String complemento;
   private String bairro;
   private String localidade;
   private String uf;
}
