package com.salesianostriana.dam.eventschess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.eventschess.pojo.Torneo;

public interface TorneoRepository extends JpaRepository<Torneo,Long> {
	
	@Query ("select t from Torneo t where (t.nombre=nombre or t.lugar=nombre or t.tipo_partida=nombre)")
	public List<Torneo> buscarPorNombre(String nombre);

}
