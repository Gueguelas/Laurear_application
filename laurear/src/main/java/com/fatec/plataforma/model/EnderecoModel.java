package com.fatec.plataforma.model;

import java.util.UUID;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EnderecoModel {

        private UUID idEndereco;
        private String logradouro;
        private String numero;
        private int cep;
        private String cidade;
        private String estado;
        private String pais;

}
