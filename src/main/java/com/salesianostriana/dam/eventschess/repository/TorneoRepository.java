package com.salesianostriana.dam.eventschess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.eventschess.pojo.TipoPartida;
import com.salesianostriana.dam.eventschess.pojo.Torneo;



@Repository
public interface TorneoRepository extends JpaRepository<Torneo,Long> {
	
/*	@Query ("select t from Torneo t where (t.nombre=nombre or t.lugar=nombre or t.tipo_partida=nombre)")
	public List<Torneo> buscarPorNombre(String nombre);*/
	
	 
	
	
	public List<Torneo> findByNombreLike(String texto);
	 
	public List<Torneo> findByLugarLike (String texto);
	 
	public List<Torneo> findByLugarContainsOrNombreContains (String texto,String texto1);
	 
	public List<Torneo> findByTipoPartida(TipoPartida texto);
	 
	

}
