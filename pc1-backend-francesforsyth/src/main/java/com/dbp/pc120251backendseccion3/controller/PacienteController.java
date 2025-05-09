package com.dbp.pc120251backendseccion3.controller;

import com.dbp.pc120251backendseccion3.model.Paciente;
import com.dbp.pc120251backendseccion3.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MÉDICO', 'ENFERMERO')")
    public List<Paciente> listar() {
        return service.listarTodos();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'RECEPCIONISTA')")
    public Paciente crear(@Valid @RequestBody Paciente paciente) {
        return service.guardar(paciente);
    }
}
