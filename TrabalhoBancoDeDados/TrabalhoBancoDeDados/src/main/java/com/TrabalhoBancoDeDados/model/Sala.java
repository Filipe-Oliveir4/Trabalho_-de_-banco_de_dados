package com.TrabalhoBancoDeDados.model;

public class Sala {
    String codSala;
    String nomeSala;
    String letraPredio;

    public Sala(String codSala, String nomeSala, String letraPredio) {
        this.codSala = codSala;
        this.nomeSala = nomeSala;
        this.letraPredio = letraPredio;
    }

    public Sala() {
    }

    public String getCodSala() {
        return codSala;
    }

    public void setCodSala(String codSala) {
        this.codSala = codSala;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public String getLetraPredio() {
        return letraPredio;
    }

    public void setLetraPredio(String letraPredio) {
        this.letraPredio = letraPredio;
    }
}
