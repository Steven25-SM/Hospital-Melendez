package com.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class RecetaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceta;

    private String indicaciones;

    @OneToOne
    @JoinColumn(name = "idConsulta")
    private Consulta consulta;

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL)
    private List<DetalleReceta> detalles;
}
