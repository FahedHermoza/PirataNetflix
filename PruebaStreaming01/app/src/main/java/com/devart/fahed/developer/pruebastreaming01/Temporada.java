package com.devart.fahed.developer.pruebastreaming01;

import java.util.UUID;

/**
 * Created by mac on 11/09/17.
 */

public class Temporada {

    private UUID id;
    private String capitulo;
    private String titulo;
    private String duracion;

    public Temporada(){
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }


    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
