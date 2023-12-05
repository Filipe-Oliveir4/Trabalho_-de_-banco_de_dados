package com.TrabalhoBancoDeDados.controller;


import com.TrabalhoBancoDeDados.model.Ocorrencia;
import com.TrabalhoBancoDeDados.repository.OcorrenciaRepository;
import com.TrabalhoBancoDeDados.verificacao.OcorrenciaVerificacao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OcorrenciaController {

    @Autowired
    private OcorrenciaRepository repository;

    private OcorrenciaVerificacao verificacao = new OcorrenciaVerificacao();

    @RequestMapping(value = "/inserirOcorrencia",method = RequestMethod.POST)
    public String salvarOcorrencia(HttpServletRequest request){
        Ocorrencia oc = new Ocorrencia();
        oc.setCodSala(request.getParameter("cod_sala"));
        oc.setCodEquipamento(Integer.parseInt((request.getParameter("cod_equipamento"))));
        oc.setDescricao(request.getParameter("descricao"));
        if(verificacao.inserirOcorrenciaNoBanco(oc)){
            repository.insertOcorrencia(oc);
            return "sucesso";
        }else{
            return "erro";
       }
    }
    @RequestMapping(value = "/todasOcorrencias",method = RequestMethod.GET)
    public List<Ocorrencia> todasOcorrencias(HttpServletRequest request){

        return repository.getAllOcorrencias();
        }
    }

