package com.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;

    private String nombres;
    private String apellidos;
    private String colegiatura;
    private String telefono;
    private String correo;
    private String estado; // activo / inactivo

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    @ManyToMany
    @JoinTable(
            name = "medico_especialidad",
            joinColumns = @JoinColumn(name = "idMedico"),
            inverseJoinColumns = @JoinColumn(name = "idEspecialidad")
    )

    private List<Especialidad> especialidades;
    @Column(length = 100)
    private String especialidad;

}
