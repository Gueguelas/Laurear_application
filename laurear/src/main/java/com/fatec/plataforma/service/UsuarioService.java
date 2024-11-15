package com.fatec.plataforma.service;

import com.fatec.plataforma.model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import com.fatec.plataforma.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioModel authenticate(String cpf, String senha) throws Exception {
        Optional<UsuarioModel> usuario = repository.findByCpf(cpf);
        if (usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            return usuario.get();
        }
        throw new Exception("CPF ou senha inválidos");
    }

    // Método para adicionar usuário
    public RedirectView addUser(UsuarioModel usuarioModel) throws Exception {
        Optional<UsuarioModel> existingEmail = repository.findByEmail(usuarioModel.getEmail());
        Optional<UsuarioModel> existingCpf = repository.findByCpf(usuarioModel.getCpf());

        if (existingEmail.isPresent()) {
            throw new Exception("Email já cadastrado");
        }

        if (existingCpf.isPresent()) {
            throw new Exception("CPF já cadastrado");
        }

        repository.save(usuarioModel);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/usuarios");
        return redirectView;
    }
}