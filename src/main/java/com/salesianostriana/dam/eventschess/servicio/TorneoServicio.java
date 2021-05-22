package com.salesianostriana.dam.eventschess.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.eventschess.pojo.TipoPartida;
import com.salesianostriana.dam.eventschess.pojo.Torneo;
import com.salesianostriana.dam.eventschess.repository.TorneoRepository;
import com.salesianostriana.dam.eventschess.servicioBase.BaseService;
@Service
/**
 * Servicio que se encarga de hacer las llamadas pertinentes a la base de datos del lado de los torneos
 * @author Pablo Repiso Sasiain
 * @since 16/05/2021
 * @version 1.1V
 */
public class TorneoServicio extends BaseService<Torneo,Long,TorneoRepository> {

	@Autowired
	private TorneoRepository torneoRepo;
	
	/**
	 * Método que le pasa al servicio base las consultas básicas
	 * @param repo
	 */
	public TorneoServicio(TorneoRepository repo) {
		super(repo);
	}
	
	/**
	 * Método que hace una llamada a la base de datos para buscar todas las coincidencias 
	 * de nombre y ubicación pasadas por parámetros.
	 * @param texto Parametro que quieres que contenga
	 * @return Devuelve la lista de Torneos que encajan con la búsqueda
	 */
	public List<Torneo> buscarGenerico (String texto){
		return torneoRepo.findByLugarContainsOrNombreContains(texto,texto);
	}
		
	/**
	 * Método que busca todos los Torneos que sean de Standard
	 * @return Lista de torneos que cumplan con ello
	 */
	public List<Torneo> buscarTorneoStandard (){
		return torneoRepo.findByTipoPartida(TipoPartida.standard);
	}
	
	/**
	 * Método que busca todos los Torneos que sean de Rapid
	 * @return Lista de torneos que cumplan con ello
	 */
	public List<Torneo> buscarTorneoRapid (){
		return torneoRepo.findByTipoPartida(TipoPartida.rapid);
	}
	
	/**
	 * Método que busca todos los Torneos que sean de Blitz
	 * @return Lista de torneos que cumplan con ello
	 */
	public List<Torneo> buscarTorneoBlitz (){
		return torneoRepo.findByTipoPartida(TipoPartida.blitz);
	}
	
}
