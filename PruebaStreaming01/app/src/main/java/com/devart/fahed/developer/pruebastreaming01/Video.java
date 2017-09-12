package com.devart.fahed.developer.pruebastreaming01;

import java.util.UUID;

/**
 * Created by mac on 3/09/17.
 */

public class Video {

    private UUID id;
    private String portada;
    private String titulo;
    private String visualizaciones;

    public Video(){
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

    public String getVisualizaciones() {
        return visualizaciones;
    }

    public void setVisualizaciones(String visualizaciones) {
        this.visualizaciones = visualizaciones;
    }
}
