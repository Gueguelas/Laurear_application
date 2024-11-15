package com.fatec.plataforma.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Faculdade")
public class FaculdadeModel {
        @Id
        @Column(name = "idFaculdade")
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private int idFaculdade;

        @Column(name = "nome")
        private String nome;

        @Column(name = "telefone")
        private String telefone;

        @Column(name = "email")
        private String email;

        @Column(name = "senha")
        private String senha;

        @ManyToOne
        @JoinColumn(name = "idEndereco")
        private EnderecoModel endereco;

        @OneToMany(mappedBy = "faculdade")
        private List<CupomModel> cupons;
}
