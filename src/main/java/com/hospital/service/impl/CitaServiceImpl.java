package com.hospital.service.impl;

import com.hospital.entity.Cita;
import com.hospital.repository.CitaRepository;
import com.hospital.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository repo;

    @Override
    public List<Cita> listarTodos() { return repo.findAll(); }

    @Override
    public Optional<Cita> buscarPorId(Long id) { return repo.findById(id); }

    @Override
    public Cita guardar(Cita cita) { return repo.save(cita); }

    @Override
    public void eliminar(Long id) { repo.deleteById(id); }

    @Override
    public List<Cita> listarPorPaciente(Long idPaciente) {
        return repo.findByPacienteIdPaciente(idPaciente);
    }
}
