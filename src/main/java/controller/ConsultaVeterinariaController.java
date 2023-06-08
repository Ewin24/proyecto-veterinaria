package controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import entity.ConsultaVeterinaria;
import jakarta.validation.Valid;
import service.IConsultaService;

@Controller
@SessionAttributes("consulta")
public class ConsultaVeterinariaController {

	@Autowired
	private IConsultaService consultaVeterinariaService;

	@RequestMapping(value =  "/consulta/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de consultas veterinarias");
		model.addAttribute("consultas", consultaVeterinariaService.findAll());

		return "listar";
	}

	@RequestMapping(value = "/consultas/form")
	public String crear(Map<String, Object> model) {

		ConsultaVeterinaria consulta = new ConsultaVeterinaria();
		model.put("consulta", consulta);
		model.put("titulo", "Formulario de Consulta Veterinaria");
		return "form-consulta";
	}

	@RequestMapping(value = "/consultas/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		ConsultaVeterinaria consulta = null;

		if (id > 0) {
			consulta = consultaVeterinariaService.FindOne(id);
			if (consulta == null) {
				return "redirect:/consultas/listar";
			}
		} else {
			return "redirect:/consultas/listar";
		}

		model.put("consulta", consulta);
		model.put("titulo", "Editar Consulta Veterinaria");
		return "form-consulta";
	}

	@RequestMapping(value = "/consultas/form", method = RequestMethod.POST)
	public String guardar(@Valid ConsultaVeterinaria consulta, BindingResult result, Model model,
			SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Consulta Veterinaria");
			return "form-consulta";
		}

		consultaVeterinariaService.save(consulta);
		status.setComplete();
		return "redirect:/consultas/listar";
	}

	@RequestMapping(value = "/consultas/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id > 0) {
			consultaVeterinariaService.delete(id);
		}
		return "redirect:/consultas/listar";
	}
}
