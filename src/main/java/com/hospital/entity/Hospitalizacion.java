package com.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Hospitalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHosp;

    private LocalDate fechaIngreso;
    private LocalDate fechaAlta;
    private String diagnosticoIngreso;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;
    @Column(length = 255)
    private String diagnostico;


    @ManyToOne
    @JoinColumn(name = "idHabitacion")
    private Habitacion habitacion;
}
