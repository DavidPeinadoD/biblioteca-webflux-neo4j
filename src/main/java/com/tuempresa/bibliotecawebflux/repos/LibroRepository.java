package com.tuempresa.bibliotecawebflux.repos;

import com.tuempresa.bibliotecawebflux.models.Libro;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface LibroRepository extends ReactiveNeo4jRepository<Libro, Long> {
    @Bean
    @NotNull
    Mono<Libro> findById(Long libroId);
    @Bean
    Flux<Libro> findLibrosByTitulo(String titulo);
    @Bean
    Flux<Libro> findAutoresByLibro(Long libroId);

}
