package com.hospital.service;

import com.hospital.entity.Habitacion;
import java.util.List;
import java.util.Optional;

public interface HabitacionService {
    List<Habitacion> listarTodos();
    Optional<Habitacion> buscarPorId(Long id);
    Habitacion guardar(Habitacion habitacion);
    void eliminar(Long id);
}
