package com.fatec.plataforma.controller;


import com.fatec.plataforma.model.ProdutoModel;
import com.fatec.plataforma.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;
    @GetMapping("/all")
    public ModelAndView getProdutosCadastrados() {
        ModelAndView modelAndView = new ModelAndView("tb_produtos.html");
        List<ProdutoModel> produtoModels = produtoRepository.findAll();
        modelAndView.addObject("produtos", produtoModels);
        modelAndView.addObject("produto", new ProdutoModel());
        return modelAndView;
    }
    @GetMapping("/catalogo")
    public ModelAndView getProdutos() {
        ModelAndView modelAndView = new ModelAndView("page_catalogo.html"); // Certifique-se que o nome do template está correto
        List<ProdutoModel> produtoModels = produtoRepository.findAll();
        modelAndView.addObject("produtos", produtoModels);
        modelAndView.addObject("produto", new ProdutoModel());
        return modelAndView;
    }
}
