package com.dbp.pc120251backendseccion3.service;

import com.dbp.pc120251backendseccion3.model.Consulta;
import com.dbp.pc120251backendseccion3.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public List<Consulta> listarTodas() {
        return repository.findAll();
    }

    public Consulta guardar(Consulta consulta) {
        return repository.save(consulta);
    }
}
