package com.salesianostriana.dam.eventschess.servicio;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.eventschess.pojo.Torneo;
import com.salesianostriana.dam.eventschess.repository.TorneoRepository;
import com.salesianostriana.dam.eventschess.servicioBase.BaseService;
@Service
public class TorneoServicio extends BaseService<Torneo,Long,TorneoRepository> {

	public TorneoServicio(TorneoRepository repo) {
		super(repo);
	}
	

}
