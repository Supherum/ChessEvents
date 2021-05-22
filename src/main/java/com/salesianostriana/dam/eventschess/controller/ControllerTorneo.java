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

/**
 * Esta clase se centra los controllers de torneos, editar, borrar, agregar,
 * siempre y cuando no necesiten el servicio de Socio.
 * @author Pablo Repiso Sasiain
 * @since 18/05/2021
 * @version 1.2V
 */
@Controller
public class ControllerTorneo {
	
	@Autowired
	private TorneoServicio torneoServicio;
		
	/**
	 * Controller que se encarga de rellenar el formulario vacio de torneo
	 * @param model Parámetro al cuál agregamos todos los parámetros que necesitamos para mostrar
	 * @return Redirigiremos al formulario de torneo
	 */
	@GetMapping("/agregar_torneo")
	public String showTorneo (Model model) {
		model.addAttribute("torneoForm",new Torneo());
		return "formulario_torneo";
	}

	/**
	 * Controller que se encarga de mostrarnos en el formulario un torneo concreto
	 * con la opción de editarlo.
	 * @param id Id del torneo que editaremos
	 * @param model  Parámetro al cuál agregamos todos los parámetros que necesitamos para mostrar
	 * @return Redirige al formulario de torneos lleno
	 */
	@GetMapping("/mostrar_torneo/{id}")
	public String showTorneo (@PathVariable("id") Long id ,Model model) {
		if(id !=null && id!=0) {
			model.addAttribute("torneoForm",torneoServicio.findById(id));
			model.addAttribute("torneo_id",id);
		}
		return "formulario_torneo";
	}
	
	/**
	 * Controller que se encarga de guardar los datos de un torneo y guardarlo en la
	 * base de datos
	 * @param torneo Torneo que se ha formado con los campos rellenos
	 * @return Redirige al index 
	 */
	@PostMapping("/guardar_torneo")
	public String saveIdTorneo (@ModelAttribute("torneoForm")Torneo torneo) {
		torneoServicio.save(torneo);
		return "redirect:/";
	}
	
	/**
	 * Controller que se encarga de borrar un torneo concreto de la base de datos. Borra el torneo si
	 * no tiene socios dentro.Si tiene socios simplemente no hace nada.
	 * @param id Id del torneo que queremos borrar
	 * @return Redirige de nuevo al index
	 */
	@GetMapping ("/borrar_torneo/{id}")
	public String removeTorneo(@PathVariable("id") Long id) {
		Torneo torneo=torneoServicio.findById(id);
		if(torneo.getSocios().size()==0)
			torneoServicio.delete(torneo);
		return "redirect:/";
	}
	
	/**
	 * Controller que te muestra los socios que hay en un torneo concreto
	 * @param id Id del torneo que queremos ver
	 * @param model  Parámetro al cuál agregamos todos los parámetros que necesitamos para mostrar
	 * @return Te redirige a la página de muestra de socios con dicho torneo
	 */
	@GetMapping("/torneo/vista/{id}")
	public String editSocio (@PathVariable("id") Long id ,Model model) {
		if(id !=null && id!=0) {
			model.addAttribute("torneoMuestra",torneoServicio.findById(id));
		}
		return "torneo_vista";
	}
	
	

}
