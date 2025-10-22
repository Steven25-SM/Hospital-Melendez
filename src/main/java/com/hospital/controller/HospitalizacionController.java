package com.hospital.controller;

import com.hospital.entity.Hospitalizacion;
import com.hospital.service.HospitalizacionService;
import com.hospital.service.HabitacionService;
import com.hospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hospitalizacion")
public class HospitalizacionController {

    @Autowired
    private HospitalizacionService hospitalizacionService;

    @Autowired
    private HabitacionService habitacionService;

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaHospitalizaciones", hospitalizacionService.listarTodos());
        model.addAttribute("listaPacientes", pacienteService.listarTodos());
        model.addAttribute("listaHabitaciones", habitacionService.listarTodos());
        model.addAttribute("hospitalizacion", new Hospitalizacion());
        return "hospitalizacion";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("hospitalizacion") Hospitalizacion h) {
        hospitalizacionService.guardar(h);
        return "redirect:/hospitalizacion";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("hospitalizacion", hospitalizacionService.buscarPorId(id).orElse(new Hospitalizacion()));
        model.addAttribute("listaHospitalizaciones", hospitalizacionService.listarTodos());
        model.addAttribute("listaPacientes", pacienteService.listarTodos());
        model.addAttribute("listaHabitaciones", habitacionService.listarTodos());
        return "hospitalizacion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        hospitalizacionService.eliminar(id);
        return "redirect:/hospitalizacion";
    }
}
