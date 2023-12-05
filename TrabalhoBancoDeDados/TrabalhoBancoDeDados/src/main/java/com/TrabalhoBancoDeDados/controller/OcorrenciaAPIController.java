package com.TrabalhoBancoDeDados.controller;

import com.TrabalhoBancoDeDados.model.Ocorrencia;
import com.TrabalhoBancoDeDados.model.Sala;
import com.TrabalhoBancoDeDados.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/ocorrencia")
public class OcorrenciaAPIController {

    @Autowired
    OcorrenciaRepository repository;

    @GetMapping("/allOcorrencias")
    public List<Ocorrencia> getallOcorrencias(){

        return repository.getAllOcorrencias();
    }
    @GetMapping("/ocorrenciaByCod/{codOcorrencia}")
    public Ocorrencia getOcorrenciaByCodOcorrencia(@PathVariable("codOcorrencia") String codOcorrencia){

        return repository.getOcorrenciaByCodOcorrencia(codOcorrencia);
    }
    @PostMapping("/solucionarOcorrencia/{codOcorrencia}")
    public void solucionarOcorrencia(@PathVariable("codOcorrencia") String codOcorrencia){
        repository.solucionarOcorrencia(codOcorrencia);
    }
}
