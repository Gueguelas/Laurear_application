package com.fatec.plataforma.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AvaliacaoModel {
    private UUID idAvaliacao;
    private UUID idAluno;
    private UUID idCupom;
    private int nota;
    private String feedback;
    private LocalDateTime timestampFeedback;

    public void AvaliarCupom(int nota, String feedback) {
        this.nota = nota;
        this.feedback = feedback;
        this.timestampFeedback = LocalDateTime.now();
    }
}
