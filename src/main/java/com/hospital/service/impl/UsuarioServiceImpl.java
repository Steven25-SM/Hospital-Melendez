package com.hospital.service.impl;

import com.hospital.entity.Usuario;
import com.hospital.repository.UsuarioRepository;
import com.hospital.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public List<Usuario> listarTodos() { return repo.findAll(); }

    @Override
    public Optional<Usuario> buscarPorId(Long id) { return repo.findById(id); }

    @Override
    public Usuario guardar(Usuario usuario) { return repo.save(usuario); }

    @Override
    public void eliminar(Long id) { repo.deleteById(id); }
}
