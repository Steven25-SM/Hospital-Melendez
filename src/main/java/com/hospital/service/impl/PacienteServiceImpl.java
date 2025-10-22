package com.hospital.service.impl;

import com.hospital.entity.Paciente;
import com.hospital.repository.PacienteRepository;
import com.hospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository repo;

    @Override
    public List<Paciente> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Optional<Paciente> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        return repo.save(paciente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
