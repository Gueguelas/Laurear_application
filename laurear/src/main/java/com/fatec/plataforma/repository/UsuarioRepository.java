package com.fatec.plataforma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

	Optional<UsuarioModel> findByCpf(String cpf);
	
	Optional<UsuarioModel> findByEmail(String email);
	
}

