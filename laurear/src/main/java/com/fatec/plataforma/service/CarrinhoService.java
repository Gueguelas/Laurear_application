package com.fatec.plataforma.service;

import java.util.ArrayList;

import com.fatec.plataforma.model.ProdutoModel;

public class CarrinhoService {
		private int id;
		private boolean aberto = true;
		private static long totInst;
		private ArrayList<ProdutoModel> produtoModels = new ArrayList<ProdutoModel>();

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

		public ArrayList<ProdutoModel> getProdutos() {
			return produtoModels;
		}

		public boolean adicionar(ProdutoModel produtoModel) {
			if(this.aberto) {
				produtoModels.add(produtoModel);
				return true;
			}
			return false;
		}

		public boolean remover(int id) {
			if(this.aberto && id >= 0 && id < produtoModels.size()) {
				produtoModels.remove(id);
				return true;
			}
			return false;
		}

		public Object finalizar() {
			if(!this.aberto || produtoModels.isEmpty() ) {
				return false;
			}
			this.aberto = false;
			double total = 0;
			for(ProdutoModel produtoModel : produtoModels) {
				total += produtoModel.getPoints();
			}
			return total;
		}
		
}

