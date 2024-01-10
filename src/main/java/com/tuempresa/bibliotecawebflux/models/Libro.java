package com.tuempresa.bibliotecawebflux.models;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Libro {

    @Id
    private Long id;

    private String nombre;
    private Boolean disponibilidad;
    private String estado;
    private Long numDisponible;
    private Long numTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getNumDisponible() {
        return numDisponible;
    }

    public void setNumDisponible(Long numDisponible) {
        this.numDisponible = numDisponible;
    }

    public Long getNumTotal() {
        return numTotal;
    }

    public void setNumTotal(Long numTotal) {
        this.numTotal = numTotal;
    }
}
