package com.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleFactura;

    private String concepto;
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "idFactura")
    private Factura factura;
}
