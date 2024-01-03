package br.com.inventario.domain.model.enus;

import lombok.Data;
import lombok.Getter;

@Getter

public enum Situacao {

    USO("USO"),
    INSERVIVEL("INSERVIVEL"),
    OCIOSO("OCIOSO");

    private String tipo;

    Situacao(String tipo) {
        this.tipo = tipo;
    }


    public String getTipo(){
        return tipo;
    }



}
