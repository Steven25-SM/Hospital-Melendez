package com.hospital.service;

import com.hospital.entity.Medico;
import java.util.List;
import java.util.Optional;

public interface MedicoService {
    List<Medico> listarTodos();
    Optional<Medico> buscarPorId(Long id);
    Medico guardar(Medico medico);
    void eliminar(Long id);
}
