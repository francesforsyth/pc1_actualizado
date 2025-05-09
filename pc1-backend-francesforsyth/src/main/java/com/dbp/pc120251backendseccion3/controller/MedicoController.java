package com.dbp.pc120251backendseccion3.controller;

import com.dbp.pc120251backendseccion3.dto.MedicoDTO;
import com.dbp.pc120251backendseccion3.model.Medico;
import com.dbp.pc120251backendseccion3.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MÉDICO', 'RECEPCIONISTA')")
    public List<Medico> listar() {
        return service.listarTodos();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Medico crear(@Valid @RequestBody MedicoDTO dto) {
        Medico medico = new Medico();
        medico.setNombre(dto.getNombre());
        medico.setEspecialidad(dto.getEspecialidad());
        medico.setCorreo(dto.getCorreo());
        return service.guardar(medico);
    }
}
