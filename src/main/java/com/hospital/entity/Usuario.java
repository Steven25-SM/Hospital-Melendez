package com.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombreUsuario;
    private String contrasena;
    private String rol;

    @OneToOne
    @JoinColumn(name = "idPaciente", unique = true)
    private Paciente paciente;

    @OneToMany(mappedBy = "usuario")
    private List<Bitacora> bitacoras;
}