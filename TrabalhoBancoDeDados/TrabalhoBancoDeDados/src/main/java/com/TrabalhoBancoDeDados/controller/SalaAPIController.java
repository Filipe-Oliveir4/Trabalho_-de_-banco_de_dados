package com.TrabalhoBancoDeDados.controller;

import com.TrabalhoBancoDeDados.model.Ocorrencia;
import com.TrabalhoBancoDeDados.model.Sala;
import com.TrabalhoBancoDeDados.repository.SalaRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sala")
public class SalaAPIController {

    @Autowired
    private SalaRepository repository;

    @GetMapping("/allSalas")
    public List<Sala> getallSalas(){

        return repository.getAllSalas();
    }

    @GetMapping("/salaByCod/{codSala}")
    public Sala getSalaByCodSala(@PathVariable("codSala") String codSala){

        return repository.getSalaByCodSala(codSala);
    }

}
