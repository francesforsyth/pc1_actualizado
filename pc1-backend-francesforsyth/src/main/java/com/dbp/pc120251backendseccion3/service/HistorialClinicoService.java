package com.dbp.pc120251backendseccion3.service;

import com.dbp.pc120251backendseccion3.model.HistorialClinico;
import com.dbp.pc120251backendseccion3.repository.HistorialClinicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialClinicoService {

    @Autowired
    private HistorialClinicoRepository repository;

    public List<HistorialClinico> listarTodos() {
        return repository.findAll();
    }

    public Optional<HistorialClinico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public HistorialClinico guardar(HistorialClinico historial) {
        return repository.save(historial);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
