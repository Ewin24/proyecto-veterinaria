package com.veterinaria.app.controllers;

import com.veterinaria.app.entity.Paciente;
import com.veterinaria.app.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import jakarta.validation.Valid;

@Controller
@SessionAttributes("pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @RequestMapping(value = "/pacientes")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de pacientes");
        model.addAttribute("pacientes", pacienteService.findAll());
        return "pacientes/listar";
    }

    @GetMapping("/form")
    public String crear(Model model) {
        Paciente paciente = new Paciente();
        model.addAttribute("paciente", paciente);
        model.addAttribute("titulo", "Formulario de Paciente");
        return "pacientes/form";
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Paciente paciente = pacienteService.FindOne(id);
        if (paciente == null) {
            return "redirect:/pacientes";
        }
        model.addAttribute("paciente", paciente);
        model.addAttribute("titulo", "Editar Paciente");
        return "pacientes/form";
    }

    @PostMapping("/form")
    public String guardar(@Valid Paciente paciente, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Paciente");
            return "pacientes/form";
        }

        pacienteService.save(paciente);
        status.setComplete();
        return "redirect:/pacientes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        pacienteService.delete(id);
        return "redirect:/pacientes";
    }
}
