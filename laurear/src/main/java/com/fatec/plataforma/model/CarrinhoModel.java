package com.fatec.plataforma.model;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoModel {
    private List<PedidoModel> pedidoModels;

    public CarrinhoModel() {
        this.pedidoModels = new ArrayList<>();
    }

    // Método para adicionar um pedido ao carrinho
    public void adicionarAoCarrinho(PedidoModel pedidoModel) {
        this.pedidoModels.add(pedidoModel);
        System.out.println("Pedido adicionado ao carrinho: " + pedidoModel);
    }

    // Método para calcular o total do carrinho
    public double calcularTotalCarrinho() {
        double total = 0;
        for (PedidoModel pedidoModel : pedidoModels) {
            total += pedidoModel.calcularPrecoTotal();
        }
        return total;
    }
    public void adicionarProduto(PedidoModel pedidoModel) {
        this.pedidoModels.add(pedidoModel);
        System.out.println("Pedido adicionado ao carrinho: " + pedidoModel);
    }
    public List<PedidoModel> getPedidos() {
        return pedidoModels;
    }
}

