package com.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBitacora;

    private String accion;
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}
