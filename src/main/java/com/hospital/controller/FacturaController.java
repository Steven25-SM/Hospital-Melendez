package com.hospital.controller;

import com.hospital.entity.Factura;
import com.hospital.service.FacturaService;
import com.hospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaFacturas", facturaService.listarTodos());
        model.addAttribute("listaPacientes", pacienteService.listarTodos());
        model.addAttribute("factura", new Factura());
        return "facturacion";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("factura") Factura factura) {
        facturaService.guardar(factura);
        return "redirect:/facturacion";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("factura", facturaService.buscarPorId(id).orElse(new Factura()));
        model.addAttribute("listaFacturas", facturaService.listarTodos());
        model.addAttribute("listaPacientes", pacienteService.listarTodos());
        return "facturacion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        facturaService.eliminar(id);
        return "redirect:/facturacion";
    }
}
