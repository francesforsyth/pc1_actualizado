package com.dbp.pc120251backendseccion3.service;

import com.dbp.pc120251backendseccion3.model.Paciente;
import com.dbp.pc120251backendseccion3.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Paciente guardar(Paciente paciente) {
        return repository.save(paciente);
    }
}
