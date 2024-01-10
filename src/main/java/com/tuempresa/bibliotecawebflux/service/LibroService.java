package com.tuempresa.bibliotecawebflux.service;
import com.tuempresa.bibliotecawebflux.models.Libro;
import com.tuempresa.bibliotecawebflux.repos.LibroRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class LibroService {
    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;

    }
public Flux<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    public Mono<Libro> getLibroById(Long libroId) {
        return libroRepository.findById(libroId);
    }
    public Mono<Libro> createLibro(Libro libro) {
        return libroRepository.save(libro);
    }
    public Mono<Void> deleteLibrobyId(Long id) {
        return libroRepository.deleteById(id);
    }
    public Mono<Libro> updateLibro(Long libroId, Libro libro) {
        return libroRepository.findById(libroId)
                .flatMap(existingLibro -> {
                    existingLibro.setNombre(libro.getNombre());
                    existingLibro.setEstado(libro.getEstado());
                    existingLibro.setNumTotal(libro.getNumTotal());
                    existingLibro.setNumDisponible(libro.getNumDisponible());
                    return libroRepository.save(existingLibro);
                });
    }


}
