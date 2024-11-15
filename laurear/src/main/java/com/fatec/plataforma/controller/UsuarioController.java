package com.fatec.plataforma.controller;

import com.fatec.plataforma.model.ProdutoModel;
import com.fatec.plataforma.model.UsuarioModel;
import com.fatec.plataforma.repository.ProdutoRepository;
import com.fatec.plataforma.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuario"
)
public class UsuarioController {
	
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProdutoRepository produtoRepository;
	
	// TB PRODUTOS
	@GetMapping("/produtos")
	public ModelAndView getProdutosCadastrados() {
		ModelAndView modelAndView = new ModelAndView("tb_produtos.html");
		List<ProdutoModel> produtoModels = produtoRepository.findAll();
		modelAndView.addObject("produtos", produtoModels);
		modelAndView.addObject("produto", new ProdutoModel());
		return modelAndView;
	}
	
	// PAGINA LOGIN-PRINCIPAL
	@GetMapping("/login")
	public String showLoginForm(Model model) {
	    model.addAttribute("usuario", new UsuarioModel());
	    return "usuario_login"; // O nome do template Thymeleaf
	}

    // Processa a autenticação do usuário
    @PostMapping("/login")
    public ModelAndView authenticateUser(@RequestParam String cpf, @RequestParam String senha) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<UsuarioModel> usuario = usuarioRepository.findByCpf(cpf);
        if (usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            modelAndView.setView(new RedirectView("/usuarios/home"));
        } else {
            modelAndView.setViewName("usuario_login");
            modelAndView.addObject("message", "CPF ou senha inválidos");
        }
        return modelAndView;
    }
    
	
	// PAGINA LOGIN-CADASTRO
	@GetMapping("/cadastro")
	public ModelAndView getUsuariosCadastro() {
		ModelAndView modelAndView = new ModelAndView("usuario_cadastro.html");
		List<UsuarioModel> usuarioModels = usuarioRepository.findAll();
		modelAndView.addObject("usuarios", usuarioModels);
		modelAndView.addObject("usuario", new UsuarioModel());
		return modelAndView;
	}
	
	// Usuarios Cadastrados
	@GetMapping
	public ModelAndView getUsuariosCadastrando() {
		ModelAndView modelAndView = new ModelAndView("tb_usuarios_cadastrados.html");
		List<UsuarioModel> usuarioModels = usuarioRepository.findAll();
		modelAndView.addObject("usuarios", usuarioModels);
		modelAndView.addObject("usuario", new UsuarioModel());
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView getUsuarioById(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("tb_usuarios_cadastrados.html");
		UsuarioModel usuarioModel = usuarioRepository.getReferenceById(id);
		List<UsuarioModel> usuarioModels = new ArrayList<>();
		usuarioModels.add(usuarioModel);
		modelAndView.addObject("usuarios", usuarioModel);
		modelAndView.addObject("usuario", new UsuarioModel());
		return modelAndView;
	}
	
	 @PostMapping
	   public ModelAndView saveUsuario(UsuarioModel usuarioModel) {
	       ModelAndView modelAndView = new ModelAndView();
	       Optional<UsuarioModel> existingUsuario = usuarioRepository.findByCpf(usuarioModel.getCpf());
	       if (existingUsuario.isPresent()) {
	           modelAndView.setViewName("usuario_cadastro");
	           modelAndView.addObject("message", "CPF já cadastrado!!");
	       } else {
	    	   usuarioRepository.save(usuarioModel);
	           modelAndView.setView(new RedirectView("usuarios/login"));
	       }
	       
	       return modelAndView;
	  }	
	
	@DeleteMapping("/{id}")
	public RedirectView deleteUsuario(@PathVariable Long id) throws Exception {
		if (id != null && id > 0) {
			usuarioRepository.deleteById(id);
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl("/usuarios");
			return redirectView; // refresh
		}
		throw new Exception("Erro ao excluir");
	}
	
	// PAGINA HOME
	@GetMapping("/home")
	public String showHome(Model model) {
	    return "page_home"; // O nome do template Thymeleaf
	}
	
	// PAGINA CATALOGO
		@GetMapping("/catalogo")
		public ModelAndView getProdutos() {
		    ModelAndView modelAndView = new ModelAndView("page_catalogo.html"); // Certifique-se que o nome do template está correto
		    List<ProdutoModel> produtoModels = produtoRepository.findAll();
		    modelAndView.addObject("produtos", produtoModels);
		    modelAndView.addObject("produto", new ProdutoModel());
		    return modelAndView;
		}

	// PAGINA CARRINHO
		@GetMapping("/carrinho")
		public ModelAndView getProdutoInCart() {
		    ModelAndView modelAndView = new ModelAndView("page_carrinho.html"); // Certifique-se que o nome do template está correto
		    List<ProdutoModel> produtoModels = produtoRepository.findAll();
		    modelAndView.addObject("produtos", produtoModels);
		    modelAndView.addObject("produto", new ProdutoModel());
		    return modelAndView;
		}
		
		
}
