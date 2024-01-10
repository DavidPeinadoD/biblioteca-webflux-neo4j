package com.tuempresa.bibliotecawebflux.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.tuempresa.bibliotecawebflux.models.Autor;
import com.tuempresa.bibliotecawebflux.models.Libro;
import com.tuempresa.bibliotecawebflux.repos.AutorRepository;
import com.tuempresa.bibliotecawebflux.repos.LibroRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class AutorResolver implements GraphQLResolver<Autor> {

    private final AutorRepository autorRepository;
    private final LibroRepository libroRepository;

    public AutorResolver(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    public Flux<Libro> libros(Autor autor) {
        // Implementa lógica para obtener los libros escritos por un autor
        return autorRepository.findLibrosByAutor_Id(autor.getId());
    }

}

