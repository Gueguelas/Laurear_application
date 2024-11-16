package com.fatec.plataforma.service;

import com.fatec.plataforma.dto.FaculdadeDTO;
import com.fatec.plataforma.model.FaculdadeModel;
import com.fatec.plataforma.repository.FaculdadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaculdadeService {
    @Autowired
    private FaculdadeRepository faculdadeRepository;
    public List<FaculdadeModel> buscarFaculdade(){
        List<FaculdadeModel> faculdade = faculdadeRepository.findAll();
        return faculdade;

    }

}
