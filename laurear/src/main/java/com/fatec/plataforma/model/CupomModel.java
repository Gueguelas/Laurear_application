package com.fatec.plataforma.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class CupomModel {

    private UUID idCupom;
    private String nome;
    private String loja;
    private StatusEnum status;
    private LocalDateTime dataExpiracao;
    private int valor;

    public void CadastrarCupom(CupomModel cupom) {
        // Implementação para cadastrar um cupom
    }

    public void AtualizarCupom(CupomModel cupom) {
        // Implementação para atualizar um cupom
    }

    public void ExcluirCupom(CupomModel cupom) {
        // Implementação para excluir um cupom
    }}
