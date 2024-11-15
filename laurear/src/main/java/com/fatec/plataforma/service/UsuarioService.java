package com.fatec.plataforma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import com.fatec.plataforma.model.Usuario;
import com.fatec.plataforma.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario authenticate(String cpf, String senha) throws Exception {
        Optional<Usuario> usuario = repository.findByCpf(cpf);
        if (usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            return usuario.get();
        }
        throw new Exception("CPF ou senha inválidos");
    }

    // Método para adicionar usuário
    public RedirectView addUser(Usuario usuario) throws Exception {
        Optional<Usuario> existingEmail = repository.findByEmail(usuario.getEmail());
        Optional<Usuario> existingCpf = repository.findByCpf(usuario.getCpf());

        if (existingEmail.isPresent()) {
            throw new Exception("Email já cadastrado");
        }

        if (existingCpf.isPresent()) {
            throw new Exception("CPF já cadastrado");
        }

        repository.save(usuario);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/usuarios");
        return redirectView;
    }
}