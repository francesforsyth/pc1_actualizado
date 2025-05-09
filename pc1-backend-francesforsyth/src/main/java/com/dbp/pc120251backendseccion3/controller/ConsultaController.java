package com.dbp.pc120251backendseccion3.controller;

import com.dbp.pc120251backendseccion3.dto.ConsultaDTO;
import com.dbp.pc120251backendseccion3.model.Consulta;
import com.dbp.pc120251backendseccion3.model.Medico;
import com.dbp.pc120251backendseccion3.model.Paciente;
import com.dbp.pc120251backendseccion3.service.ConsultaService;
import com.dbp.pc120251backendseccion3.repository.MedicoRepository;
import com.dbp.pc120251backendseccion3.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MÉDICO', 'RECEPCIONISTA')")
    public List<Consulta> listar() {
        return service.listarTodas();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('MÉDICO', 'RECEPCIONISTA')")
    public Consulta crear(@Valid @RequestBody ConsultaDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        Consulta consulta = new Consulta();
        consulta.setFechaHora(dto.getFechaHora());
        consulta.setMotivo(dto.getMotivo());
        consulta.setDiagnostico(dto.getDiagnostico());
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);

        return service.guardar(consulta);
    }
}
