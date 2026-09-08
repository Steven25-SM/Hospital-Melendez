package com.hospital.service.impl;

import com.hospital.entity.Factura;
import com.hospital.repository.FacturaRepository;
import com.hospital.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository repo;

    @Override
    public List<Factura> listarTodos() { return repo.findAll(); }

    @Override
    public Optional<Factura> buscarPorId(Long id) { return repo.findById(id); }

    @Override
    public Factura guardar(Factura factura) { return repo.save(factura); }

    @Override
    public void eliminar(Long id) { repo.deleteById(id); }
    
    @Override
    public List<Factura> listarPorPaciente(Long idPaciente) {
        return repo.findByPacienteIdPaciente(idPaciente);
    }
}
