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
public class FaculdadeModel {
        private UUID idEmpresa;
        private String nome;
        private String telefone;
        private String email;
        private String senha;
        private EnderecoModel endereco;
        private List<AlunoModel> alunos;
        private List<CupomModel> cupons;
        private LocalDateTime dataCadastro;

}
