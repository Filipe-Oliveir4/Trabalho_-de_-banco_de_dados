package com.TrabalhoBancoDeDados.controller;

import com.TrabalhoBancoDeDados.model.Ocorrencia;
import com.TrabalhoBancoDeDados.model.OcorrenciaSalaVW;
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

    @GetMapping("/numOcorrenciaByCodSala/{codSala}")
    public String numOcorrenciaByCodSala(@PathVariable("codSala") String codSala){

        return "Num ocorrencias: "+repository.numOcorrenciaPorCodSala(codSala);
    }

    @GetMapping("/OcorenciaSalaVw")
    public List<OcorrenciaSalaVW> getOcorrenciaSalaVw(){

        return repository.getOcorrenciaSalaVw();
    }

    @DeleteMapping("/deleteOcorrenciaByCodOcorrencia/{codOcorrencia}")
    public void deleteOcorrenciaByCodOcorrencia(@PathVariable("codOcorrencia") String codOcorrencia){
        repository.deleteOcorrenciaByCodOcorrencia(codOcorrencia);
    }
}
