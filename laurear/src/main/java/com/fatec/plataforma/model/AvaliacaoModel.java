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
@Table(name = "avaliacao")
public class AvaliacaoModel {
        @Id
        @Column(name = "idAvaliacao")
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private UUID idAvaliacao;

        @Column(name = "descricao")
        private String descricao;

        @Column(name = "feedback")
        private String feedback;

        @Column(name = "data")
        @Temporal(TemporalType.TIMESTAMP)
        private Date data;

        @ManyToOne
        @JoinColumn(name = "idAluno")
        private AlunoModel aluno;
}
