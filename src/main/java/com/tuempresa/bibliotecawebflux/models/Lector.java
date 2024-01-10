package com.tuempresa.bibliotecawebflux.models;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Lector {

    @Id
    private Long id;

    private String nombre;
    private String apellidos;

}
