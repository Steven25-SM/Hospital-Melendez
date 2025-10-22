package com.hospital.controller;

import com.hospital.entity.Medico;
import com.hospital.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaMedicos", medicoService.listarTodos());
        model.addAttribute("medico", new Medico());
        return "medicos";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("medico") Medico medico) {
        medicoService.guardar(medico);
        return "redirect:/medicos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("medico", medicoService.buscarPorId(id).orElse(new Medico()));
        model.addAttribute("listaMedicos", medicoService.listarTodos());
        return "medicos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        medicoService.eliminar(id);
        return "redirect:/medicos";
    }
}
