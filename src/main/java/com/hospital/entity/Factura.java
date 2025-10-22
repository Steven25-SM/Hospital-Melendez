package com.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    private LocalDate fechaEmision;
    private Double total;
    private String estado;


    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;
    @Column(length = 255)
    private String descripcion;


    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<DetalleFactura> detalles;
}
