package com.salesianostriana.dam.eventschess.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.eventschess.pojo.Torneo;
import com.salesianostriana.dam.eventschess.repository.TorneoRepository;
import com.salesianostriana.dam.eventschess.servicioBase.BaseService;
@Service
public class TorneoServicio extends BaseService<Torneo,Long,TorneoRepository> {

	@Autowired
	private TorneoRepository torneoRepo;
	
	public TorneoServicio(TorneoRepository repo) {
		super(repo);
	}
	
	/*Busca los torneos por nombre*/
	public List<Torneo> buscarTorneoPorNombre (String nombre) {
		return torneoRepo.buscarPorNombre(nombre);
	}

}
