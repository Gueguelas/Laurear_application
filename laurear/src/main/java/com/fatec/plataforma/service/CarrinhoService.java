package com.fatec.plataforma.service;

import java.util.ArrayList;

import com.fatec.plataforma.model.Produto;

public class CarrinhoService {
		private int id;
		private boolean aberto = true;
		private static long totInst;
		private ArrayList<Produto> produtos = new ArrayList<Produto>();

		public CarrinhoService( int id) {
			this.id = id;
			totInst++;

		}

		public CarrinhoService() {
			totInst++;
		}

		public int getId() {
			return id;
		}

		public boolean isAberto() {
			return aberto;
		}

		public long getTotInst() {
			return totInst;
		}

		public ArrayList<Produto> getProdutos() {
			return produtos;
		}

		public boolean adicionar(Produto produto) {
			if(this.aberto) {
				produtos.add(produto);
				return true;
			}
			return false;
		}

		public boolean remover(int id) {
			if(this.aberto && id >= 0 && id < produtos.size()) {
				produtos.remove(id);
				return true;
			}
			return false;
		}

		public Object finalizar() {
			if(!this.aberto || produtos.isEmpty() ) {
				return false;
			}
			this.aberto = false;
			double total = 0;
			for(Produto produto : produtos) {
				total += produto.getPoints();
			}
			return total;
		}
		
}

