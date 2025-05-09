package com.dbp.pc120251backendseccion3.repository;

import com.dbp.pc120251backendseccion3.model.HistorialClinico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialClinicoRepository extends JpaRepository<HistorialClinico, Long> {
    HistorialClinico findByPacienteId(Long pacienteId);
}
