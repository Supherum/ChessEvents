package com.salesianostriana.dam.eventschess.servicio;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.eventschess.pojo.Socio;
import com.salesianostriana.dam.eventschess.pojo.Torneo;
import com.salesianostriana.dam.eventschess.repository.SocioRepository;
import com.salesianostriana.dam.eventschess.servicioBase.BaseService;

@Service

public class SocioServicio extends BaseService<Socio, Long, SocioRepository>{

	@Autowired
	SocioRepository socioRepository;
	
	public SocioServicio(SocioRepository repo) {
		super(repo);
	}
	
	public void guardarAsociacion (Socio socio,Torneo torneo) {
		socio.addTorneo(torneo);
		
	}
	

	
}
