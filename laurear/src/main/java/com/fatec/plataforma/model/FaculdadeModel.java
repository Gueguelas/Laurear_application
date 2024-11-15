package com.fatec.plataforma.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

        public void CadastrarFaculdade(FaculdadeModel faculdade, EnderecoModel endereco) {
            // Implementação para cadastrar faculdade com endereço
        }

        public void RedefinirSenha(String novaSenha) {
            this.senha = novaSenha;
        }

        public boolean Autenticar(String email, String senha) {
            return this.email.equals(email) && this.senha.equals(senha);
        }

        public void ListarCupons() {
            // Implementação para listar cupons
        }
}
