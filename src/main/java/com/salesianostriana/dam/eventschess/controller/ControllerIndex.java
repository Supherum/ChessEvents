package com.salesianostriana.dam.eventschess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.eventschess.pojo.IdObject;
import com.salesianostriana.dam.eventschess.pojo.Torneo;
import com.salesianostriana.dam.eventschess.servicio.SocioServicio;
import com.salesianostriana.dam.eventschess.servicio.TorneoServicio;

@Controller
public class ControllerIndex {

	@Autowired
	 private SocioServicio socioServicio;
	
	@Autowired
	private TorneoServicio torneoServicio;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("lista_socio", socioServicio.findAll());
		model.addAttribute("lista_torneo",torneoServicio.findAll());
		model.addAttribute("idObject",new IdObject());
		return "index";
	}
	
	@GetMapping ("/torneo/")
	public String buscarTorneoPorNombre (Model model,@RequestParam("q") Optional<String> busqueda){
		
		List<Torneo> torneos;
		
			torneos = torneoServicio.buscarGenerico(busqueda.get());
			model.addAttribute("torneos_busqueda",torneos);
			model.addAttribute("lista_socio", socioServicio.findAll());
			model.addAttribute("lista_torneo",torneoServicio.findAll());
			model.addAttribute("idObject",new IdObject());
		return "index";
		
	}
	
	@PostMapping("/agregar-asociacion/{id}/{id2}")
	public String addAsociacion (@PathVariable ("id") Long id,@PathVariable ("id2") Long id2, Model model) {
		socioServicio.guardarAsociacion(socioServicio.findById(id),torneoServicio.findById(id2));
		return "redirect:/";
	}
	
	
	
	
	
	@GetMapping ("/torneo/standard")
	public String buscarTorneoStandard (Model model) {
		
		List<Torneo> torneos;
		
		torneos = torneoServicio.buscarTorneoStandard();
		model.addAttribute("torneos_busqueda",torneos);
		model.addAttribute("lista_socio", socioServicio.findAll());
		model.addAttribute("lista_torneo",torneoServicio.findAll());
		model.addAttribute("idObject",new IdObject());
		return "index";
	}
	
	@GetMapping ("/torneo/blitz")
	public String buscarTorneoBlitz (Model model) {
		
		List<Torneo> torneos;
		
		torneos = torneoServicio.buscarTorneoBlitz();
		model.addAttribute("torneos_busqueda",torneos);
		model.addAttribute("lista_socio", socioServicio.findAll());
		model.addAttribute("lista_torneo",torneoServicio.findAll());
		model.addAttribute("idObject",new IdObject());
		return "index";
	}
	
	@GetMapping ("/torneo/rapid")
	public String buscarTorneoRapid (Model model) {
		
		List<Torneo> torneos;
		
		torneos = torneoServicio.buscarTorneoRapid();
		model.addAttribute("torneos_busqueda",torneos);
		model.addAttribute("lista_socio", socioServicio.findAll());
		model.addAttribute("lista_torneo",torneoServicio.findAll());
		model.addAttribute("idObject",new IdObject());
		return "index";
	}
		
	
}
