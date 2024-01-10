package com.tuempresa.bibliotecawebflux.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.tuempresa.bibliotecawebflux.models.Libro;
import com.tuempresa.bibliotecawebflux.repos.AutorRepository;
import com.tuempresa.bibliotecawebflux.repos.LibroRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class LibroResolver implements GraphQLResolver<Libro> {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    public LibroResolver(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }
    @Bean
    public Flux<Libro> autores(Libro libro) {
        return libroRepository.findAutoresByLibro(libro.getId());
    }
    @Bean
    public Mono<Libro> findById(Long libroId) {
        return libroRepository.findById(libroId);
    }
}
