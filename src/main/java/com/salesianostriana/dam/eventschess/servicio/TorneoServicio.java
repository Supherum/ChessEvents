package com.salesianostriana.dam.eventschess.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.eventschess.pojo.TipoPartida;
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

	public List<Torneo> buscarGenerico (String texto){
		return torneoRepo.findByLugarContainsOrNombreContains(texto,texto);
	}
	
	
	public List<Torneo> buscarTorneoStandard (){
		return torneoRepo.findByTipoPartida(TipoPartida.standard);
	}
	public List<Torneo> buscarTorneoRapid (){
		return torneoRepo.findByTipoPartida(TipoPartida.rapid);
	}
	public List<Torneo> buscarTorneoBlitz (){
		return torneoRepo.findByTipoPartida(TipoPartida.blitz);
	}
	
}
