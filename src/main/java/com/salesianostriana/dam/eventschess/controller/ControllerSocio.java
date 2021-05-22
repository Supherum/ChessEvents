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
/**
 * Clase que se encargará de los controllers de los socios, como agregar, borrar, editar. Todos estos 
 * controllers son los que solo necesitan el servicio de Socio.
 * @author Pablo Repiso Sasiain
 * @since 18/05/2021
 * @version 1.2V
 */
@Controller
public class ControllerSocio {

	@Autowired
	 private SocioServicio socioServicio;	
	
	/**
	 * Controler que se encarga de redirigir a un usuario
	 * @param model Parámetro al cuál agregamos todos los parámetros que necesitamos para mostrar
	 * @return Redirige a la plantilla del formulario de socio
	 */
	@GetMapping("/agregar_socio")
	public String showSocio (Model model)
	{
		model.addAttribute("socioForm",new Socio());
		return "formulario_socio";
	}
	
	
	/**
	 * Controler que se encarga de rellenarte el formulario con los datos del id
	 * @param id Id del socio
 	 * @param model Parámetro al cuál agregamos todos los parámetros que necesitamos para mostrar
	 * @return  Redirige a la página del formulario
	 */
	@GetMapping("/mostrar_socio/{id}")
	public String editSocio (@PathVariable("id") Long id ,Model model) {
		if(id !=null && id!=0) {
			model.addAttribute("socioForm",socioServicio.findById(id));
			model.addAttribute("socio_id",id);
		}
		return "formulario_socio";
	}
	
	
	/**
	 * Controlador que se encarga de guardar un socio en el formulario
	 * @param socio El socio que nos llega por el formulario
	 * @return Redirigimos a la página principal
	 */
	@PostMapping("/guardar_socio")
	public String saveIdSocio (@ModelAttribute("socioForm")Socio socio) {
		socioServicio.save(socio);
		return "redirect:/";
	}
	
	
	/**
	 * Este controlador nos borra todos los torneos que tiene un socio al borrarlo de la base de datos,
	 * es decir, un borrado en casacada manual.
	 * @param id Id del socio que necesitamos borrar
	 * @return Redirigimos al index de nuevo
	 */
	@GetMapping ("/borrar_socio/{id}")
	public String removeSocio(@PathVariable("id") Long id) {
		Socio socio=socioServicio.findById(id);
		
		if(socio.getTorneos().size()>0)
		{
			for (int i = 0; i < socio.getTorneos().size(); i++)
			{
				socioServicio.save(socio.removeTorneo(socio.getTorneos().get(i)));
			}
		}
		
		socioServicio.delete(socio);
		return "redirect:/";
	}
	
	
}
