package com.fatec.plataforma.model;

import java.util.ArrayList;
import java.util.List;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarrinhoModel {
    private int id;
    private boolean aberto = true;
    private static long totInst;
    private ArrayList<ProdutoModel> produtoModels = new ArrayList<ProdutoModel>();


    public ArrayList<ProdutoModel> getProdutos() {
        return produtoModels;
    }
    private List<PedidoModel> pedidoModels;
}

