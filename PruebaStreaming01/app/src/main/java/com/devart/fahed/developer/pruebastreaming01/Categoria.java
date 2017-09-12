package com.devart.fahed.developer.pruebastreaming01;

import java.util.UUID;

/**
 * Created by mac on 5/09/17.
 */

public class Categoria {

    private UUID id;
    private String portada;
    private String titulo;
    private int icono;

    public Categoria(){
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}
