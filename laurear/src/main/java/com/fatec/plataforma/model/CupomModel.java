package com.fatec.plataforma.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cupom")
public class CupomModel {

    @Id
    @Column(name = "idCupom")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idCupom;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "validade")
    @Temporal(TemporalType.DATE)
    private Date validade;

    @Column(name = "status")
    private String status; // "Disponivel" ou "Indisponivel"

    @Column(name = "valor")
    private int valor;

    @ManyToOne
    @JoinColumn(name = "idAluno")
    private AlunoModel aluno;

    @ManyToOne
    @JoinColumn(name = "idFaculdade")
    private FaculdadeModel faculdade;


}
