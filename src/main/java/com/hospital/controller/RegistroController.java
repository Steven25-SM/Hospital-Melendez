package com.hospital.controller;

import com.hospital.entity.Paciente;
import com.hospital.entity.Usuario;
import com.hospital.repository.PacienteRepository;
import com.hospital.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "registro";
    }

    @PostMapping
    public String registrar(@ModelAttribute("paciente") Paciente paciente,
                            @RequestParam String nombreUsuario,
                            @RequestParam String contrasena) {

        if (usuarioRepository.existsByNombreUsuario(nombreUsuario)) {
            return "redirect:/registro?error=usuario";
        }

        if (pacienteRepository.existsByDni(paciente.getDni())) {
            return "redirect:/registro?error=dni";
        }

        if (pacienteRepository.existsByCorreo(paciente.getCorreo())) {
            return "redirect:/registro?error=correo";
        }

        paciente.setEstado("ACTIVO");

        Paciente pacienteGuardado = pacienteRepository.save(paciente);

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasena(contrasena);
        usuario.setRol("PACIENTE");
        usuario.setPaciente(pacienteGuardado);

        usuarioRepository.save(usuario);

        pacienteGuardado.setUsuario(usuario);
        pacienteRepository.save(pacienteGuardado);

        return "redirect:/login?registro=exitoso";
    }
}