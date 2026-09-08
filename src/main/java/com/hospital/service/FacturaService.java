package com.hospital.service;

import com.hospital.entity.Factura;
import java.util.List;
import java.util.Optional;

public interface FacturaService {
    List<Factura> listarTodos();
    Optional<Factura> buscarPorId(Long id);
    Factura guardar(Factura factura);
    void eliminar(Long id);
    List<Factura> listarPorPaciente(Long idPaciente);
}
