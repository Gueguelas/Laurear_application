package com.fatec.plataforma.model;

import java.util.UUID;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PedidoModel {

    // Classe Pedido
        private UUID id;
        private String nomeProduto;
        private int quantidade;
        private double precoUnitario;

        public PedidoModel(String nomeProduto, int quantidade, double precoUnitario) {
            this.id = UUID.randomUUID(); // Gera um ID único
            this.nomeProduto = nomeProduto;
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
        }

        public UUID getId() {
            return id;
        }

        public String getNomeProduto() {
            return nomeProduto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public double getPrecoUnitario() {
            return precoUnitario;
        }

        public double calcularPrecoTotal() {
            return quantidade * precoUnitario;
        }


        @Override
        public String toString() {
            return "Pedido [id=" + id + ", nomeProduto=" + nomeProduto + ", quantidade=" + quantidade + ", precoUnitario=" + precoUnitario + "]";
        }
    }

