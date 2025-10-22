package com.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsulta;

    private LocalDate fecha;
    private LocalTime hora;
    private String motivoConsulta;
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL)
    private List<Diagnostico> diagnosticos;

    @OneToOne(mappedBy = "consulta", cascade = CascadeType.ALL)
    private RecetaMedica receta;
}
