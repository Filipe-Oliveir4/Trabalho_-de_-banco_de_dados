package com.TrabalhoBancoDeDados.verificacao;


import com.TrabalhoBancoDeDados.model.Ocorrencia;


public class OcorrenciaVerificacao {

    public OcorrenciaVerificacao() {
    }

    public boolean inserirOcorrenciaNoBanco(Ocorrencia ocorrencia){
        if (ocorrencia.getCodEquipamento()<0 || ocorrencia.getCodSala().equals("") || ocorrencia.getDescricao().equals("")){
            return false;
        }else{
            return true;
        }
    }
}
