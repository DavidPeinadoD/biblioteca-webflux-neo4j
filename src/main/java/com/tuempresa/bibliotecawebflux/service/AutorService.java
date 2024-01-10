package com.tuempresa.bibliotecawebflux.service;

import com.tuempresa.bibliotecawebflux.models.Autor;
import com.tuempresa.bibliotecawebflux.repos.AutorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;

    }
    public Flux<Autor> getAllAutores(String nombre) {
        return autorRepository.findAll();
    }
    public Mono<Autor> getAutorById(Long autorId) {
        return autorRepository.findById(autorId);
    }
    public Mono<Autor> createAutor(Autor autor) {
        return autorRepository.save(autor);
    }
    public Mono<Void> deleteAutor(Long autorId) {
        return autorRepository.deleteById(autorId);
    }
    public Mono<Autor> updateAutor(Long autorId, Autor autor) {
        return autorRepository.findById(autorId)
                .flatMap(existingAutor -> {
                    existingAutor.setNombre(autor.getNombre());
                    existingAutor.setApellidos(autor.getApellidos());
                    return autorRepository.save(existingAutor);
                });
    }
}
