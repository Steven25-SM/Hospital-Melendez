package com.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiagnostico;

    private String descripcion;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "idConsulta")
    private Consulta consulta;
}
