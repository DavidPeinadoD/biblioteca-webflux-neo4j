package com.tuempresa.bibliotecawebflux.repos;

import com.tuempresa.bibliotecawebflux.models.Genero;
import com.tuempresa.bibliotecawebflux.models.Libro;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Flux;

public interface GeneroRepository extends ReactiveNeo4jRepository<Genero, Long> {
    Flux<Libro> findLibrosByGenero(Long generoId);
}
