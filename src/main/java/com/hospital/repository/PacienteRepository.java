package com.hospital.repository;

import com.hospital.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByUsuarioNombreUsuario(String nombreUsuario);

    boolean existsByDni(String dni);

    boolean existsByCorreo(String correo);
}