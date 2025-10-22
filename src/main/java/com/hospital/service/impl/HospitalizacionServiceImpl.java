package com.hospital.service.impl;

import com.hospital.entity.Hospitalizacion;
import com.hospital.repository.HospitalizacionRepository;
import com.hospital.service.HospitalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalizacionServiceImpl implements HospitalizacionService {

    @Autowired
    private HospitalizacionRepository repo;

    @Override
    public List<Hospitalizacion> listarTodos() { return repo.findAll(); }

    @Override
    public Optional<Hospitalizacion> buscarPorId(Long id) { return repo.findById(id); }

    @Override
    public Hospitalizacion guardar(Hospitalizacion hospitalizacion) { return repo.save(hospitalizacion); }

    @Override
    public void eliminar(Long id) { repo.deleteById(id); }
}
