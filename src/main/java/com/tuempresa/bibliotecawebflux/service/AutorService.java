package com.tuempresa.bibliotecawebflux.service;

import com.tuempresa.bibliotecawebflux.models.Autor;
import com.tuempresa.bibliotecawebflux.repos.AutorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;

    }
    @Bean
    public Flux<Autor> getAllAutores(String nombre) {
        return autorRepository.findAll();
    }
    @Bean
    public Mono<Autor> getAutorById(Long autorId) {
        return autorRepository.findById(autorId);
    }
    @Bean
    public Mono<Autor> createAutor(Autor autor) {
        return autorRepository.save(autor);
    }
    @Bean
    public Mono<Void> deleteAutor(Long autorId) {
        return autorRepository.deleteById(autorId);
    }
    @Bean
    public Mono<Autor> updateAutor(Long autorId, Autor autor) {
        return autorRepository.findById(autorId)
                .flatMap(existingAutor -> {
                    existingAutor.setNombre(autor.getNombre());
                    existingAutor.setApellidos(autor.getApellidos());
                    return autorRepository.save(existingAutor);
                });
    }
}
