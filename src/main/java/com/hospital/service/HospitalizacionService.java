package com.hospital.service;

import com.hospital.entity.Hospitalizacion;
import java.util.List;
import java.util.Optional;

public interface HospitalizacionService {
    List<Hospitalizacion> listarTodos();
    Optional<Hospitalizacion> buscarPorId(Long id);
    Hospitalizacion guardar(Hospitalizacion hospitalizacion);
    void eliminar(Long id);
}
