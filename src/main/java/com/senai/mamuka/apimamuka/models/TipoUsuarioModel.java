package com.senai.mamuka.apimamuka.models;

public enum TipoUsuarioModel {
    ADMIN("admin"),
    DESENVOLVEDOR("dev"),
    CLIENTE("gestor");

    private String tipo;

    TipoUsuarioModel(String tipo) {
        this.tipo = tipo;
    }

    public String getRole() {
        return tipo;
    }
}
