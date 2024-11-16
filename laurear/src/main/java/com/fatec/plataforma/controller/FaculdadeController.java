package com.fatec.plataforma.controller;

import com.fatec.plataforma.dto.FaculdadeDTO;
import com.fatec.plataforma.model.FaculdadeModel;
import com.fatec.plataforma.service.FaculdadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/faculdade")
public class FaculdadeController {
    @Autowired
    private FaculdadeService faculdadeService;

    @GetMapping("/all")
    public ResponseEntity<List<FaculdadeModel>> buscarTodasFaculdades(){
        return ResponseEntity.ok(faculdadeService.buscarFaculdade());
    }
}
