package com.veterinaria.app.controllers;

import org.springframework.ui.Model;
import com.veterinaria.app.entity.Usuario;
import com.veterinaria.app.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios", usuarioService.findAll());

        return "usuarios/listar";
    }

    @RequestMapping(value = "/usuarios/form")
    public String crear(Map<String, Object> model) {

        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        model.put("titulo", "Formulario de Usuario");
        return "form-usuario";
    }

    @RequestMapping(value = "/usuarios/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {

        Usuario usuario = null;

        if (id > 0) {
            usuario = usuarioService.FindOne(id);
            if (usuario == null) {
                return "redirect:/usuarios/listar";
            }
        } else {
            return "redirect:/usuarios/listar";
        }

        model.put("usuario", usuario);
        model.put("titulo", "Editar Usuario");
        return "form-usuario";
    }

    @RequestMapping(value = "/usuarios/form", method = RequestMethod.POST)
    public String guardar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Usuario");
            return "form-usuario";
        }

        usuarioService.save(usuario);
        status.setComplete();
        return "redirect:/usuarios/listar";
    }

    @RequestMapping(value = "/usuarios/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id) {
        if (id > 0) {
            usuarioService.delete(id);
        }
        return "redirect:/usuarios/listar";
    }
}
