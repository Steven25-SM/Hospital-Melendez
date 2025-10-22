package com.hospital.controller;

import com.hospital.entity.Paciente;
import com.hospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaPacientes", pacienteService.listarTodos());
        model.addAttribute("paciente", new Paciente());
        return "pacientes";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("paciente") Paciente paciente) {
        pacienteService.guardar(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("paciente", pacienteService.buscarPorId(id).orElse(new Paciente()));
        model.addAttribute("listaPacientes", pacienteService.listarTodos());
        return "pacientes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        pacienteService.eliminar(id);
        return "redirect:/pacientes";
    }
}
