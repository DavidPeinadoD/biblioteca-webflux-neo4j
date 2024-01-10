package com.tuempresa.bibliotecawebflux.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.tuempresa.bibliotecawebflux.models.Genero;
import com.tuempresa.bibliotecawebflux.models.Libro;
import com.tuempresa.bibliotecawebflux.repos.GeneroRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneroResolver implements GraphQLResolver<Genero> {

    private final GeneroRepository generoRepository;

    public GeneroResolver(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<Libro> libros(Genero genero) {
        // Implementa lógica para obtener los libros asociados a un género
        return generoRepository.findLibrosByGenero(genero.getId()).collectList().block();
    }
}
