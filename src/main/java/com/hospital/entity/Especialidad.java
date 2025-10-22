package com.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecialidad;

    private String nombre;
    private String descripcion;

    @ManyToMany(mappedBy = "especialidades")
    private List<Medico> medicos;
}
