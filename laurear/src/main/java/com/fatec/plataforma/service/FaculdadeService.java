package com.fatec.plataforma.service;

import com.fatec.plataforma.dto.FaculdadeDTO;
import com.fatec.plataforma.model.FaculdadeModel;
import com.fatec.plataforma.repository.FaculdadeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class FaculdadeService {
    private FaculdadeRepository faculdadeRepository;
    public FaculdadeModel registrarFaculdade(FaculdadeDTO data){
        FaculdadeModel faculdade= new FaculdadeModel(data.idFaculdade(), data.nome(), data.telefone(), data.email(),data.senha(), data.endereco(),data.cupons());
        faculdadeRepository.save(faculdade);
        return faculdade;
    }
}
