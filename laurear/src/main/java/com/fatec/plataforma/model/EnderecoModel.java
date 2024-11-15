package com.fatec.plataforma.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Endereco")
public class EnderecoModel {

        @Id
        @Column(name = "idEndereco")
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private int idEndereco;

        @Column(name = "logradouro")
        private String logradouro;

        @Column(name = "numero")
        private int numero;

        @Column(name = "complemento")
        private String complemento;

        @Column(name = "cidade")
        private String cidade;

        @Column(name = "estado")
        private String estado;

        @Column(name = "pais")
        private String pais;

        @Column(name = "cep")
        private String cep;


}
