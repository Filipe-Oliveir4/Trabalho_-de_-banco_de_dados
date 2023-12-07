package com.TrabalhoBancoDeDados.model;

public class OcorrenciaSalaVW {
    int codOcorrencia;
    String codSala;
    String descricao;
    String nomeSala;

    public OcorrenciaSalaVW() {
    }

    public int getCodOcorrencia() {
        return codOcorrencia;
    }

    public void setCodOcorrencia(int codOcorrencia) {
        this.codOcorrencia = codOcorrencia;
    }

    public String getCodSala() {
        return codSala;
    }

    public void setCodSala(String codSala) {
        this.codSala = codSala;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }
}
