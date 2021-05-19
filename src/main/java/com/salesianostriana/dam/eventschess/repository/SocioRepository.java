package com.salesianostriana.dam.eventschess.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.eventschess.pojo.Socio;

public interface SocioRepository extends JpaRepository<Socio,Long>{

	/*@Query ("Select s from Socio s where s.fecha_nacimiento>socio_fecha")
	 public List <Socio> filtrarPorEdad (@Param ("socio_fecha") LocalDate date);*/

}
