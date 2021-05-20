package com.salesianostriana.dam.eventschess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.eventschess.pojo.Socio;
import com.salesianostriana.dam.eventschess.servicio.SocioServicio;

@Controller
public class ControllerSocio {

	@Autowired
	 private SocioServicio socioServicio;	
	
	@GetMapping("/agregar_socio")
	public String showSocio (Model model)
	{
		model.addAttribute("socioForm",new Socio());
		return "formulario_socio";
	}
	
	
	/* EDIT */
	@GetMapping("/mostrar_socio/{id}")
	public String editSocio (@PathVariable("id") Long id ,Model model) {
		if(id !=null && id!=0) {
			model.addAttribute("socioForm",socioServicio.findById(id));
			model.addAttribute("socio_id",id);
		}
		return "formulario_socio";
	}
	
	
	@PostMapping("/guardar_socio")
	public String saveIdSocio (@ModelAttribute("socioForm")Socio socio) {
		socioServicio.save(socio);
		return "redirect:/";
	}
	
	
	@GetMapping ("/borrar_socio/{id}")
	public String removeSocio(@PathVariable("id") Long id,Model model) {
		socioServicio.delete(socioServicio.findById(id));
		return "redirect:/";
	}
	
	
}
