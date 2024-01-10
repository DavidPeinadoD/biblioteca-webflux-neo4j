package com.tuempresa.bibliotecawebflux.repos;

import com.tuempresa.bibliotecawebflux.models.Lector;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface LectorRepository extends ReactiveNeo4jRepository<Lector, Long> {
    // Puedes añadir consultas personalizadas si es necesario
}
