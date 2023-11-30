package com.Trabalho.de.banco.de.dados.verificacao;

import com.Trabalho.de.banco.de.dados.model.Ocorrencia;
import org.springframework.context.annotation.Bean;


public class OcorrenciaVerificacao {

    public OcorrenciaVerificacao() {
    }

    public boolean verificaDadosParaBanco(Ocorrencia ocorrencia){
        if (ocorrencia.getCodEquipamento()<0 || ocorrencia.getCodSala().equals("") || ocorrencia.getDescricao().equals("")){
            return false;
        }else{
            return true;
        }
    }
}
