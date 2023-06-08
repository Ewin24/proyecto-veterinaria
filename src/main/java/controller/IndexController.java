package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Bienvenido");
        return "index";
    }

    @RequestMapping("/usuarios")
    public String clientes() {
        return "redirect:/usuarios/listar";
    }

    @RequestMapping("/pacientes")
    public String pacientes() {
        return "redirect:/pacientes/listar";
    }
    
    @RequestMapping("/reportes")
    public String consultas() {
        return "redirect:/reportes/reportes";
    }
}
