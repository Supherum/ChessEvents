package com.salesianostriana.dam.eventschess.servicio;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.eventschess.pojo.Socio;
import com.salesianostriana.dam.eventschess.pojo.Torneo;
import com.salesianostriana.dam.eventschess.repository.SocioRepository;
import com.salesianostriana.dam.eventschess.repository.TorneoRepository;
import com.salesianostriana.dam.eventschess.servicioBase.BaseService;

@Service
/**
 * Servicio de Socio que se comunica con la base de datos. Nos encontraremos con la extensión que hereda de BaseService con las
 * funciones básicas y además con una función que se encará de la lógica de negocios.
 * @author Pablo Repiso Sasiain
 * @version 1.0V
 * @since 16/05/2021
 */
public class SocioServicio extends BaseService<Socio, Long, SocioRepository>{

	@Autowired
	SocioRepository socioRepository;
	@Autowired
	TorneoRepository torneoRepository;
	
	/**
	 * Servicio que manda las funciones básicas al BaseService
	 * @param repo Repositorio que usa
	 */
	public SocioServicio(SocioRepository repo) {
		super(repo);
	}
	
	/**
	 * Este método comprobará bajo qué circustancias puede hacerse una asociación, primero mirará que no sea vacio, 
	 * después mirará que el tamaño actual no es superior al máximo, luego mirará que el socio que se añade
	 * no esté ya dentro del torneo y por último mirará que tu rating es el necesario para poder apuntarte 
	 * a dicho torneo
	 * @param socio Socio al que se le intenta apuntar
	 * @param torneo Torneo al que se le quiere apuntar
	 */
	public void guardarAsociacion (Long socio,Long torneo) {
		Optional<Socio> s = socioRepository.findById(socio);
		Optional<Torneo> t =torneoRepository.findById(torneo);
		if(t.isEmpty() || s.isEmpty()) {
		}
		else if(t.get().getSocios().size() < t.get().getParticipantes_maximos() && !t.get().getSocios().contains(s.get()) && t.get().getRating_minimo()<=s.get().ratingByType(t.get().getTipoPartida())) {
		socioRepository.save(s.get().addTorneo(t.get()));
		}
	
	}
}
