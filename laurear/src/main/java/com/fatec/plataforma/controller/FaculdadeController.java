package com.fatec.plataforma.controller;

import com.fatec.plataforma.dto.FaculdadeDTO;
import com.fatec.plataforma.model.FaculdadeModel;
import com.fatec.plataforma.repository.FaculdadeRepository;
import com.fatec.plataforma.service.FaculdadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/faculdade")
public class FaculdadeController {
    @Autowired
    private FaculdadeService faculdadeService;

    @PostMapping("/cadastrar")
    public ResponseEntity<FaculdadeModel> cadastrarFaculdade(@RequestBody FaculdadeDTO body){
        FaculdadeModel faculdade = this.faculdadeService.registrarFaculdade(body);
        return ResponseEntity.ok(faculdade);
    }
}
