package com.hospital.service.impl;

import com.hospital.entity.Habitacion;
import com.hospital.repository.HabitacionRepository;
import com.hospital.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionServiceImpl implements HabitacionService {

    @Autowired
    private HabitacionRepository repo;

    @Override
    public List<Habitacion> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Optional<Habitacion> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Override
    public Habitacion guardar(Habitacion habitacion) {
        return repo.save(habitacion);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
