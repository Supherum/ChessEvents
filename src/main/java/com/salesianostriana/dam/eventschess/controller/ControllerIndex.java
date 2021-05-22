package com.salesianostriana.dam.eventschess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.eventschess.pojo.RegistroSocioTorneoCommandObject;
import com.salesianostriana.dam.eventschess.pojo.Torneo;
import com.salesianostriana.dam.eventschess.servicio.SocioServicio;
import com.salesianostriana.dam.eventschess.servicio.TorneoServicio;
/**
 * El controlador de el índice o index que necesita ambos servicios, se encargará de hacer las búsquedas, filtrar e incluso de registrar la asociación,
 * a parte de cargar la página principal y sus listas.
 * @author Pablo Repiso Sasiain
 * @since 20/05/2021
 * @version 1.0V
 */
@Controller
public class ControllerIndex {

	@Autowired
	 private SocioServicio socioServicio;
	
	@Autowired
	private TorneoServicio torneoServicio;
	
	/**
	 * Controlador base que carga la página principal sin ninguna cosa adicional
	 * @param model Parámetro al cuál agregamos todos los parámetros que necesitamos para mostrar
	 * @return Devuelve el index
	 */
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("lista_socio", socioServicio.findAll());
		model.addAttribute("lista_torneo",torneoServicio.findAll());
		model.addAttribute("idObject",new RegistroSocioTorneoCommandObject());
		return "index";
	}
	
	/**
	 * Controlador que se encarga de hacer las búsquedas, solo buscará por Nombre y Ubicación
	 * @param model Parámetro al cuál agregamos todos los parámetros que necesitamos para mostrar
	 * @param busqueda Parámetro que nos lo pasarán por un RequestParam (un input) y haremos un filtrado por ese parámetro
	 * @return Devuelve el index pero con los datos de la tabla cargada 
	 */
	@GetMapping ("/torneo/")
	public String buscarTorneoPorNombre (Model model,@RequestParam("q") Optional<String> busqueda){
		
		List<Torneo> torneos;
		
			torneos = torneoServicio.buscarGenerico(busqueda.get());
			model.addAttribute("torneos_busqueda",torneos);
			model.addAttribute("lista_socio", socioServicio.findAll());
			model.addAttribute("lista_torneo",torneoServicio.findAll());
			model.addAttribute("idObject",new RegistroSocioTorneoCommandObject());
		return "index";
		
	}
	
	/**
	 * Controlador que se encarga de hacer la asociación del ambos objetos. Utilizamos un objeto
	 * que guarda las ids y las usaremos para gregar la asociación.
	 * @param idObject Objeto que guarda dentro las id del socio y del torneo
	 * @return Lleva al controlador base para que recargue la página
	 */
	@PostMapping("/agregar-asociacion/")
	public String addAsociacion (@ModelAttribute ("idObject") RegistroSocioTorneoCommandObject idObject) {	
		socioServicio.guardarAsociacion(idObject.getSocio_id(),idObject.getTorneo_id());
		return "redirect:/";
	}
	 																																												
	
	/**
	 * Controlador que se encarga de hacer el borrado de un socio concreto en un determinado torneo
	 * @param id1	Id del socio
	 * @param id2	Id del torneo
	 * @return Lleva al controlador base para que recargue la página
	 */	
	@GetMapping ("/borrar/{id1}/{id2}")
	public String borrarTorneoSocio(@PathVariable("id1") Long id1,@PathVariable("id2") Long id2) {
		socioServicio.save(socioServicio.findById(id1).removeTorneo(torneoServicio.findById(id2)));
		return "redirect:/";
	}
	
	
	
	
	
	/**
	 * Controlador que se encarga traerse todos los torneos que sean de la categoría standard
	 * @param model Parámetro al cuál agregamos todos los parámetros que necesitamos para mostrar
	 * @return Recarga la página index  con la lista actualizada
	 */
	@GetMapping ("/torneo/standard")
	public String buscarTorneoStandard (Model model) {
		
		List<Torneo> torneos;
		
		torneos = torneoServicio.buscarTorneoStandard();
		model.addAttribute("torneos_busqueda",torneos);
		model.addAttribute("lista_socio", socioServicio.findAll());
		model.addAttribute("lista_torneo",torneoServicio.findAll());
		model.addAttribute("idObject",new RegistroSocioTorneoCommandObject());
		return "index";
	}
	
	

	/**
	 * Controlador que se encarga traerse todos los torneos que sean de la categoría blitz
	 * @param model Parámetro al cuál agregamos todos los parámetros que necesitamos para mostrar
	 * @return Recarga la página index con la lista actualizada
	 */
	@GetMapping ("/torneo/blitz")
	public String buscarTorneoBlitz (Model model) {
		
		List<Torneo> torneos;
		
		torneos = torneoServicio.buscarTorneoBlitz();
		model.addAttribute("torneos_busqueda",torneos);
		model.addAttribute("lista_socio", socioServicio.findAll());
		model.addAttribute("lista_torneo",torneoServicio.findAll());
		model.addAttribute("idObject",new RegistroSocioTorneoCommandObject());
		return "index";
	}
	
	

	/**
	 * Controlador que se encarga traerse todos los torneos que sean de la categoría blitz
	 * @param model Parámetro al cuál agregamos todos los parámetros que necesitamos para mostrar
	 * @return Recarga la página index con la lista actualizada
	 */
	@GetMapping ("/torneo/rapid")
	public String buscarTorneoRapid (Model model) {
		
		List<Torneo> torneos;
		
		torneos = torneoServicio.buscarTorneoRapid();
		model.addAttribute("torneos_busqueda",torneos);
		model.addAttribute("lista_socio", socioServicio.findAll());
		model.addAttribute("lista_torneo",torneoServicio.findAll());
		model.addAttribute("idObject",new RegistroSocioTorneoCommandObject());
		return "index";
	}
		
	
}
