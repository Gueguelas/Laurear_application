package com.fatec.plataforma.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table
	@Entity(name = "tb_pedidos")
	public class Pedidos implements Serializable {
		
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String cpf;
		private int id_produto;
		private double points;


}
