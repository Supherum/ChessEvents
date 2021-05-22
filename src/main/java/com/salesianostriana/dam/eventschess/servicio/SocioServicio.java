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

public class SocioServicio extends BaseService<Socio, Long, SocioRepository>{

	@Autowired
	SocioRepository socioRepository;
	@Autowired
	TorneoRepository torneoRepository;
	
	public SocioServicio(SocioRepository repo) {
		super(repo);
	}
	
	
	public void guardarAsociacion (Long socio,Long torneo) {
		Optional<Socio> s = socioRepository.findById(socio);
		Optional<Torneo> t =torneoRepository.findById(torneo);
		if(t.isEmpty() || s.isEmpty()) {
		}
		else if(t.get().getParticipantes_actuales() < t.get().getParticipantes_maximos() && !t.get().getSocios().contains(s.get()) && t.get().getRating_minimo()<=s.get().ratingByType(t.get().getTipoPartida())) {
		socioRepository.save(s.get().addTorneo(t.get()));
		}
		
		

	
	}
}
