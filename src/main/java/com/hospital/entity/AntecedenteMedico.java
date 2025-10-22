package com.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AntecedenteMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntecedente;

    private String tipo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idHistoria")
    private HistoriaClinica historiaClinica;
}
