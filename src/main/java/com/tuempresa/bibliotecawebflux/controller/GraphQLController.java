package com.tuempresa.bibliotecawebflux.controller;

import com.tuempresa.bibliotecawebflux.models.Autor;
import com.tuempresa.bibliotecawebflux.models.Genero;
import com.tuempresa.bibliotecawebflux.models.Libro;
import com.tuempresa.bibliotecawebflux.service.AutorService;
import com.tuempresa.bibliotecawebflux.service.GeneroService;
import com.tuempresa.bibliotecawebflux.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/graphql")
public class GraphQLController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private GeneroService generoService;

    // Consulta GraphQL para buscar libros por título, autor o categoría
    @RequestMapping("/libros")
    public Flux<Libro> mostrarLibros() {
        return libroService.getAllLibros();
    }

    @RequestMapping("/libro/{id}")
    public Mono<Libro> mostrarLibroPorId(Long id) {
        return libroService.getLibroById(id);
    }

    // Mutación GraphQL para agregar un libro
    @RequestMapping("/agregarLibro")
    public Mono<Libro> agregarLibro(Long id, String titulo, String autor, String categoria) {
        // Lógica para agregar un libro, puedes incluir validaciones y manejo de errores
        Libro nuevoLibro = new Libro();
        return libroService.createLibro(nuevoLibro);
    }

    // Mutación GraphQL para editar un libro
    @RequestMapping("/editarLibro")
    public Mono<Libro> editarLibro(Long libroId, Libro libro) {
        // Lógica para editar un libro, puedes incluir validaciones y manejo de errores
        return libroService.updateLibro(libroId, libro);
    }

    // Mutación GraphQL para eliminar un libro
    @RequestMapping("/eliminarLibro")
    public Mono<Void> eliminarLibro(Long id) {
        // Lógica para eliminar un libro, puedes incluir validaciones y manejo de errores
        return libroService.deleteLibrobyId(id);
    }

    // Mutación GraphQL para agregar un autor
    @RequestMapping("/agregarAutor")
    public Mono<Autor> agregarAutor(Long autorId, String nombre, String apellidos) {
        // Lógica para agregar un autor, puedes incluir validaciones y manejo de errores
        Autor nuevoAutor = new Autor();
        return autorService.createAutor(nuevoAutor);
    }

    // Mutación GraphQL para editar un autor
    @RequestMapping("/editarAutor")
    public Mono<Autor> editarAutor(Long autorId, Autor autor) {
        // Lógica para editar un autor, puedes incluir validaciones y manejo de errores
        return autorService.updateAutor(autorId, autor);
    }

    // Mutación GraphQL para eliminar un autor
    @RequestMapping("/eliminarAutor")
    public Mono<Void> eliminarAutor(Long id) {
        // Lógica para eliminar un autor, puedes incluir validaciones y manejo de errores
        return autorService.deleteAutor(id);
    }

    // Mutación GraphQL para agregar una categoría
    @RequestMapping("/agregarGenero")
    public Mono<Genero> agregarGenero() {
        // Lógica para agregar una categoría, puedes incluir validaciones y manejo de errores
        Genero nuevoGenero = new Genero();
        return generoService.createGenero(nuevoGenero);
    }

    // Mutación GraphQL para eliminar una categoría
    @RequestMapping("/eliminarCategoria")
    public Mono<Void> eliminarCategoria(Long id, Genero genero) {
        // Lógica para eliminar una categoría, puedes incluir validaciones y manejo de errores
        return generoService.deleteGenero(genero);
    }
}
