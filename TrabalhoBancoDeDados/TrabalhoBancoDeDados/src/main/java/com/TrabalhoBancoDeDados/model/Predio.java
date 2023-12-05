package com.TrabalhoBancoDeDados.model;

public class Predio {
    String letraPredio;

    public Predio(String letra_predio) {
        this.letraPredio = letra_predio;
    }

    public Predio() {
    }

    public String getLetraPredio() {
        return letraPredio;
    }

    public void setLetraPredio(String letraPredio) {
        this.letraPredio = letraPredio;
    }

}
