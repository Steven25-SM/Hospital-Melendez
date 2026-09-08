package com.hospital.controller;

import com.hospital.entity.Factura;
import com.hospital.entity.Paciente;
import com.hospital.entity.Usuario;
import com.hospital.repository.UsuarioRepository;
import com.hospital.service.FacturaService;
import com.hospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facturacion")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public String listar(
            Model model,
            Authentication authentication
    ) {

        boolean esAdmin = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        
        if (esAdmin) {

            model.addAttribute(
                    "listaFacturas",
                    facturaService.listarTodos()
            );

            model.addAttribute(
                    "listaPacientes",
                    pacienteService.listarTodos()
            );

            model.addAttribute(
                    "factura",
                    new Factura()
            );

            return "facturacion";
        }

        Usuario usuario = usuarioRepository
                .findByNombreUsuario(authentication.getName())
                .orElseThrow();

        Paciente paciente = usuario.getPaciente();

        model.addAttribute(
                "listaFacturas",
                facturaService.listarPorPaciente(
                        paciente.getIdPaciente()
                )
        );

        return "facturacion-paciente";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute("factura") Factura factura
    ) {

        facturaService.guardar(factura);

        return "redirect:/facturacion";
    }


    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model
    ) {

        model.addAttribute(
                "factura",
                facturaService.buscarPorId(id)
                        .orElse(new Factura())
        );

        model.addAttribute(
                "listaFacturas",
                facturaService.listarTodos()
        );

        model.addAttribute(
                "listaPacientes",
                pacienteService.listarTodos()
        );

        return "facturacion";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        facturaService.eliminar(id);

        return "redirect:/facturacion";
    }
}