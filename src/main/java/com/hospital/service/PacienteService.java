package com.hospital.service;

import com.hospital.entity.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteService {
    List<Paciente> listarTodos();
    Optional<Paciente> buscarPorId(Long id);
    Paciente guardar(Paciente paciente);
    void eliminar(Long id);
}
