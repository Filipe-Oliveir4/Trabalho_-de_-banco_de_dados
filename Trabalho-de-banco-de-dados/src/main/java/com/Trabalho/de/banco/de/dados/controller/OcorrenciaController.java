package com.Trabalho.de.banco.de.dados.controller;

import com.Trabalho.de.banco.de.dados.model.Ocorrencia;
import com.Trabalho.de.banco.de.dados.repository.OcorrenciaRepository;
import com.Trabalho.de.banco.de.dados.verificacao.OcorrenciaVerificacao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
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
        System.out.println(oc.getCodEquipamento() +" "+ oc.getDescricao()+" "+oc.getCodSala());
        if(verificacao.verificaDadosParaBanco(oc)){
            repository.insertOcorrencia(oc);
            return "sucesso";
        }else{
            return "erro";
       }

    }
}
