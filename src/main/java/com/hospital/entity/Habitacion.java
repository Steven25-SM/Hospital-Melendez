package com.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabitacion;

    private String numero;
    private String tipo;
    private String estado;

    @OneToMany(mappedBy = "habitacion")
    private List<Hospitalizacion> hospitalizaciones;
}
