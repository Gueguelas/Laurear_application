package com.fatec.plataforma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatec.plataforma.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
