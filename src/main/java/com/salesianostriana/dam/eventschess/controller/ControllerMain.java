package com.salesianostriana.dam.eventschess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.eventschess.pojo.Socio;
import com.salesianostriana.dam.eventschess.servicio.SocioServicio;
import com.salesianostriana.dam.eventschess.servicio.TorneoServicio;

@Controller
public class ControllerMain {

	@Autowired
	 private SocioServicio socioServicio;
	@Autowired
	private TorneoServicio torneoServicio;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("lista_socio", socioServicio.findAll());
		model.addAttribute("lista_torneo",torneoServicio.findAll());
		model.addAttribute("socioApuntar",new Socio());
		return "index";
	}
	
	/* Pone el socio en el index para apuntarlo */
	@GetMapping("/apuntar/{id}")
	public String cargarSocioIndex (@PathVariable("id") Long id, Model model) {
		model.addAttribute("socioApuntar",socioServicio.findById(id));
		model.addAttribute("lista_socio", socioServicio.findAll());
		model.addAttribute("lista_torneo",torneoServicio.findAll());
		model.addAttribute("socioApuntar",new Socio());
		return "index";
	}

	
}
