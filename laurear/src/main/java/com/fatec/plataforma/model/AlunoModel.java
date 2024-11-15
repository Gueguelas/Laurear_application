package com.fatec.plataforma.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlunoModel {
    private UUID idAluno;
    private int matricula;
    private String nome;
    private String telefone;
    private int idade;
    private String email;
    private String senha;
    private int pontos;
    private List<CupomModel> cupons;
    private LocalDateTime dataCadastro;


    public List<CupomModel> ListarCupons() {
        return this.cupons;
    }
}
