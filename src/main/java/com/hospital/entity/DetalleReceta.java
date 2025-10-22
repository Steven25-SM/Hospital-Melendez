package com.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DetalleReceta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleReceta;

    private String medicamento;
    private String dosis;
    private String frecuencia;
    private String duracion;

    @ManyToOne
    @JoinColumn(name = "idReceta")
    private RecetaMedica receta;
}
