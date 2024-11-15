package com.fatec.plataforma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fatec.plataforma.model.Produto;
import com.fatec.plataforma.model.Usuario;
import com.fatec.plataforma.repository.UsuarioRepository;
import com.fatec.plataforma.repository.ProdutoRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProdutoRepository produtoRepository;
	
	// TB PRODUTOS
	@GetMapping("/produtos")
	public ModelAndView getProdutosCadastrados() {
		ModelAndView modelAndView = new ModelAndView("tb_produtos.html");
		List<Produto> produtos = produtoRepository.findAll();
		modelAndView.addObject("produtos", produtos);
		modelAndView.addObject("produto", new Produto());
		return modelAndView;
	}
	
	// PAGINA LOGIN-PRINCIPAL
	@GetMapping("/login")
	public String showLoginForm(Model model) {
	    model.addAttribute("usuario", new Usuario()); 
	    return "usuario_login"; // O nome do template Thymeleaf
	}

    // Processa a autenticação do usuário
    @PostMapping("/login")
    public ModelAndView authenticateUser(@RequestParam String cpf, @RequestParam String senha) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Usuario> usuario = usuarioRepository.findByCpf(cpf);
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
		List<Usuario> usuarios = usuarioRepository.findAll();
		modelAndView.addObject("usuarios", usuarios);
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
	
	// Usuarios Cadastrados
	@GetMapping
	public ModelAndView getUsuariosCadastrando() {
		ModelAndView modelAndView = new ModelAndView("tb_usuarios_cadastrados.html");
		List<Usuario> usuarios = usuarioRepository.findAll();
		modelAndView.addObject("usuarios", usuarios);
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView getUsuarioById(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("tb_usuarios_cadastrados.html");
		Usuario usuario = usuarioRepository.getReferenceById(id);
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario);
		modelAndView.addObject("usuarios", usuario);
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
	
	 @PostMapping
	   public ModelAndView saveUsuario(Usuario usuario) {
	       ModelAndView modelAndView = new ModelAndView();
	       Optional<Usuario> existingUsuario = usuarioRepository.findByCpf(usuario.getCpf());
	       if (existingUsuario.isPresent()) {
	           modelAndView.setViewName("usuario_cadastro");
	           modelAndView.addObject("message", "CPF já cadastrado!!");
	       } else {
	    	   usuarioRepository.save(usuario);
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
		    List<Produto> produtos = produtoRepository.findAll();
		    modelAndView.addObject("produtos", produtos);
		    modelAndView.addObject("produto", new Produto());
		    return modelAndView;
		}

	// PAGINA CARRINHO
		@GetMapping("/carrinho")
		public ModelAndView getProdutoInCart() {
		    ModelAndView modelAndView = new ModelAndView("page_carrinho.html"); // Certifique-se que o nome do template está correto
		    List<Produto> produtos = produtoRepository.findAll();
		    modelAndView.addObject("produtos", produtos);
		    modelAndView.addObject("produto", new Produto());
		    return modelAndView;
		}
		
		
}
