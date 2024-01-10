package com.tuempresa.bibliotecawebflux.service;


import com.tuempresa.bibliotecawebflux.models.Prestamo;
import com.tuempresa.bibliotecawebflux.repos.PrestamoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public Flux<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    public Mono<Prestamo> getPrestamoById(Long id) {
        return prestamoRepository.findById(id);
    }

    public Mono<Prestamo> createPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public Mono<Void> deletePrestamoById(Long id) {
        return prestamoRepository.deleteById(id);
    }

    public Mono<Prestamo> updatePrestamo(Long id, Prestamo prestamo) {
        return prestamoRepository.findById(id)
                .flatMap(existingPrestamo -> {
                    // Realizar las modificaciones necesarias en el prestamo existente
                    existingPrestamo.setNombre(prestamo.getNombre());
                    existingPrestamo.setFechaInicio(prestamo.getFechaInicio());
                    existingPrestamo.setFechaDevolucion(prestamo.getFechaDevolucion());

                    // Guardar el prestamo modificado
                    return prestamoRepository.save(existingPrestamo);
                });
    }
}
