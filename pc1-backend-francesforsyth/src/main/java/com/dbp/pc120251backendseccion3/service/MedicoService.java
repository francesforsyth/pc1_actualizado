package com.dbp.pc120251backendseccion3.service;

import com.dbp.pc120251backendseccion3.model.Medico;
import com.dbp.pc120251backendseccion3.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public List<Medico> listarTodos() {
        return repository.findAll();
    }

    public Medico guardar(Medico medico) {
        return repository.save(medico);
    }
}
