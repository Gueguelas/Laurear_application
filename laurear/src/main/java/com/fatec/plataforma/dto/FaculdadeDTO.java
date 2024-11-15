package com.fatec.plataforma.dto;

import com.fatec.plataforma.model.CupomModel;
import com.fatec.plataforma.model.EnderecoModel;

import java.util.List;

public record FaculdadeDTO(int idFaculdade, String nome, String telefone, String email, String senha, EnderecoModel endereco, List<CupomModel> cupons) {
}
