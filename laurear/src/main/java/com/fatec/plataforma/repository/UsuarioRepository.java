package com.fatec.plataforma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.plataforma.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByCpf(String cpf);
	
	Optional<Usuario> findByEmail(String email);
	
}

