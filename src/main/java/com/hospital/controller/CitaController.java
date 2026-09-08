package com.hospital.controller;

import com.hospital.entity.Cita;
import com.hospital.entity.Paciente;
import com.hospital.entity.Usuario;
import com.hospital.repository.UsuarioRepository;
import com.hospital.service.CitaService;
import com.hospital.service.MedicoService;
import com.hospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public String listar(Model model, Authentication authentication) {

        boolean esAdmin = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (esAdmin) {

            model.addAttribute(
                    "listaCitas",
                    citaService.listarTodos()
            );

            model.addAttribute(
                    "listaPacientes",
                    pacienteService.listarTodos()
            );

            model.addAttribute(
                    "listaMedicos",
                    medicoService.listarTodos()
            );

            model.addAttribute(
                    "cita",
                    new Cita()
            );

            return "citas";
        }

        Usuario usuario = usuarioRepository
                .findByNombreUsuario(authentication.getName())
                .orElseThrow();

        Paciente paciente = usuario.getPaciente();

        model.addAttribute(
                "listaCitas",
                citaService.listarPorPaciente(paciente.getIdPaciente())
        );

        model.addAttribute(
                "listaMedicos",
                medicoService.listarTodos()
        );

        model.addAttribute(
                "cita",
                new Cita()
        );

        return "citas-paciente";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("cita") Cita cita) {

        citaService.guardar(cita);

        return "redirect:/citas";
    }

    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model
    ) {

        model.addAttribute(
                "cita",
                citaService.buscarPorId(id)
                        .orElse(new Cita())
        );

        model.addAttribute(
                "listaCitas",
                citaService.listarTodos()
        );

        model.addAttribute(
                "listaPacientes",
                pacienteService.listarTodos()
        );

        model.addAttribute(
                "listaMedicos",
                medicoService.listarTodos()
        );

        return "citas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        citaService.eliminar(id);

        return "redirect:/citas";
    }

    @PostMapping("/agendar")
    public String agendar(
            @ModelAttribute("cita") Cita cita,
            Authentication authentication
    ) {

        Usuario usuario = usuarioRepository
                .findByNombreUsuario(authentication.getName())
                .orElseThrow();

        Paciente paciente = usuario.getPaciente();

        cita.setPaciente(paciente);
        cita.setEstado("PENDIENTE");

        citaService.guardar(cita);

        return "redirect:/citas";
    }
}