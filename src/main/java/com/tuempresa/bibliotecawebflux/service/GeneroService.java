package com.tuempresa.bibliotecawebflux.service;

import com.tuempresa.bibliotecawebflux.models.Autor;
import com.tuempresa.bibliotecawebflux.models.Genero;
import com.tuempresa.bibliotecawebflux.repos.GeneroRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class GeneroService {
    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public Flux<Genero> getAllGeneros(String nombre) {
        return generoRepository.findAll();
    }

    public Mono<Genero> createGenero(Genero genero) {
        return generoRepository.save(genero);
    }
    public Mono<Void> deleteGenero(Genero genero){
        return generoRepository.delete(genero);
    }


}
