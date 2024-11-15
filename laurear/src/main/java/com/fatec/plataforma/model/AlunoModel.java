package com.fatec.plataforma.model;

import java.time.LocalDateTime;
import java.util.Date;
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
@Table(name = "Aluno")
public class AlunoModel {
    @Id
    @Column(name = "idAluno")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idAluno;

    @Column(name = "matricula")
    private int matricula;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "pontos")
    private int pontos;

    @Column(name = "dataNascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "idEndereco")
    private EnderecoModel endereco;

    @OneToMany(mappedBy = "aluno")
    private List<CupomModel> cupons;
}
