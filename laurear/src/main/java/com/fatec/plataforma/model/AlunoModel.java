package com.fatec.plataforma.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    public void CadastrarAluno(AlunoModel aluno, EnderecoModel endereco) {
        // Implementação para cadastrar aluno com endereço
    }

    public void AtualizarAluno(AlunoModel aluno) {
        // Implementação para atualizar aluno
    }

    public void RedefinirSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    public boolean Autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public List<CupomModel> ListarCupons() {
        return this.cupons;
    }
}
