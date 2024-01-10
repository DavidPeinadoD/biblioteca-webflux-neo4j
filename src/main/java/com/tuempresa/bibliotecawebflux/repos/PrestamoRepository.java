package com.tuempresa.bibliotecawebflux.repos;

import com.tuempresa.bibliotecawebflux.models.Prestamo;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface PrestamoRepository extends ReactiveNeo4jRepository<Prestamo, Long> {
    // Puedes añadir consultas personalizadas si es necesario
}
