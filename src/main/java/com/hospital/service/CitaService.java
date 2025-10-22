package com.hospital.service;

import com.hospital.entity.Cita;
import java.util.List;
import java.util.Optional;

public interface CitaService {
    List<Cita> listarTodos();
    Optional<Cita> buscarPorId(Long id);
    Cita guardar(Cita cita);
    void eliminar(Long id);
}
