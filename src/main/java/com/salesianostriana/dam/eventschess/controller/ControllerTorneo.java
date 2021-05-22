package com.salesianostriana.dam.eventschess.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.eventschess.pojo.Torneo;
import com.salesianostriana.dam.eventschess.servicio.TorneoServicio;


@Controller
public class ControllerTorneo {
	
	@Autowired
	private TorneoServicio torneoServicio;
		
	
	@GetMapping("/agregar_torneo")
	public String showTorneo (Model model) {
		model.addAttribute("torneoForm",new Torneo());
		return "formulario_torneo";
	}

	@GetMapping("/mostrar_torneo/{id}")
	public String showTorneo (@PathVariable("id") Long id ,Model model) {
		if(id !=null && id!=0) {
			model.addAttribute("torneoForm",torneoServicio.findById(id));
			model.addAttribute("torneo_id",id);
		}
		return "formulario_torneo";
	}
		
	@PostMapping("/guardar_torneo")
	public String saveIdTorneo (@ModelAttribute("torneoForm")Torneo torneo) {
		torneoServicio.save(torneo);
		return "redirect:/";
	}
	
	@GetMapping ("/borrar_torneo/{id}")
	public String removeTorneo(@PathVariable("id") Long id,Model model) {
		Torneo torneo=torneoServicio.findById(id);
		if(torneo.getParticipantes_actuales()==0)
			torneoServicio.delete(torneo);
		return "redirect:/";
	}
	
	@GetMapping("/torneo/vista/{id}")
	public String editSocio (@PathVariable("id") Long id ,Model model) {
		if(id !=null && id!=0) {
			model.addAttribute("torneoMuestra",torneoServicio.findById(id));
		}
		return "torneo_vista";
	}
	
	

}
