package com.TrabalhoBancoDeDados.model;

public class Equipamento {
    Integer codEquipamento;
    String tipoEquipamento;
    String marca;
    String codSala;

    public Equipamento(Integer codEquipamento, String tipoEquipamento, String marca, String codSala) {
        this.codEquipamento = codEquipamento;
        this.tipoEquipamento = tipoEquipamento;
        this.marca = marca;
        this.codSala = codSala;
    }

    public Equipamento() {
    }

    public Integer getCodEquipamento() {
        return codEquipamento;
    }

    public void setCodEquipamento(Integer codEquipamento) {
        this.codEquipamento = codEquipamento;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodSala() {
        return codSala;
    }

    public void setCodSala(String codSala) {
        this.codSala = codSala;
    }
}
