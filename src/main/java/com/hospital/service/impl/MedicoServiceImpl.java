package com.hospital.service.impl;

import com.hospital.entity.Medico;
import com.hospital.repository.MedicoRepository;
import com.hospital.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository repo;

    @Override
    public List<Medico> listarTodos() { return repo.findAll(); }

    @Override
    public Optional<Medico> buscarPorId(Long id) { return repo.findById(id); }

    @Override
    public Medico guardar(Medico medico) { return repo.save(medico); }

    @Override
    public void eliminar(Long id) { repo.deleteById(id); }
}
