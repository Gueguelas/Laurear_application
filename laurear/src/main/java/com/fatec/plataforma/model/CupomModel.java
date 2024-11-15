package com.fatec.plataforma.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CupomModel {

    private UUID idCupom;
    private String nome;
    private String loja;
    private StatusEnum status;
    private LocalDateTime dataExpiracao;
    private int valor;

}
