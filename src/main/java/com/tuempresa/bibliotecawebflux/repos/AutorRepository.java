package com.tuempresa.bibliotecawebflux.repos;

import com.tuempresa.bibliotecawebflux.models.Autor;
import com.tuempresa.bibliotecawebflux.models.Libro;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Flux;

public interface AutorRepository extends ReactiveNeo4jRepository<Autor, Long> {

    Flux<Libro> findLibrosByAutor_Id(Long autorId);
    Flux<Autor> findAutoresByLibroId(Long libroId);

}
