package com.fatec.plataforma.controller;

import com.fatec.plataforma.repository.FaculdadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/faculdade")
public class FaculdadeController {
    @Autowired
    private FaculdadeRepository faculdadeRepository;

    @PostMapping("/cadastrar")
    public List<ResponseEntity> cadastrarFaculdade(ResponseBody body){

    }
}
