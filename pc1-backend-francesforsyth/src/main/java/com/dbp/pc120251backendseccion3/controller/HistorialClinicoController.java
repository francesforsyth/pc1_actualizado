package com.dbp.pc120251backendseccion3.controller;

import com.dbp.pc120251backendseccion3.model.HistorialClinico;
import com.dbp.pc120251backendseccion3.service.HistorialClinicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historiales")
public class HistorialClinicoController {

    @Autowired
    private HistorialClinicoService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MÉDICO')")
    public List<HistorialClinico> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MÉDICO')")
    public Optional<HistorialClinico> obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('MÉDICO')")
    public HistorialClinico crear(@RequestBody HistorialClinico historial) {
        return service.guardar(historial);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
