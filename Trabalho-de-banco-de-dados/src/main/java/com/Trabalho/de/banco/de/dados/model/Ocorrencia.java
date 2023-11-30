package com.Trabalho.de.banco.de.dados.model;

import java.util.Date;

public class Ocorrencia {
    int codOcorrencia;
    String codSala;
    Integer codEquipamento;
    Date dataOcorrencia;
    boolean solucionado;
    String descricao;



    public Ocorrencia(int codOcorrencia, String codSala, Integer codEquipamento, Date dataOcorrencia, boolean solucionado) {
        this.codOcorrencia = codOcorrencia;
        this.codSala = codSala;
        this.codEquipamento = codEquipamento;
        this.dataOcorrencia = dataOcorrencia;
        this.solucionado = solucionado;
    }

    public Ocorrencia(String codSala, Integer codEquipamento ) {
        this.codSala = codSala;
        this.codEquipamento = codEquipamento;
    }

    public Ocorrencia() {
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

    public Integer getCodEquipamento() {
        return codEquipamento;
    }

    public void setCodEquipamento(Integer codEquipamento) {
        this.codEquipamento = codEquipamento;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public boolean isSolucionado() {
        return solucionado;
    }

    public void setSolucionado(boolean solucionado) {
        this.solucionado = solucionado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
