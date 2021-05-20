package com.salesianostriana.dam.eventschess.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.eventschess.pojo.Socio;


@Repository
public interface SocioRepository extends JpaRepository<Socio,Long>{

	/*@Query ("Select s from Socio s where s.fecha_nacimiento>socio_fecha")
	 public List <Socio> filtrarPorEdad (@Param ("socio_fecha") LocalDate date);*/

}
