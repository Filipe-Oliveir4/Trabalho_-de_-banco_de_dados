package com.TrabalhoBancoDeDados.controller;


import com.TrabalhoBancoDeDados.model.Predio;
import com.TrabalhoBancoDeDados.repository.PredioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/predio")
public class PredioAPIController {

    @Autowired
    PredioRepository repository;

    @GetMapping("/getAllPredio")
    public List<Predio> getOcorrenciaSalaVw(){

        return repository.getAllPredios();
    }
}
