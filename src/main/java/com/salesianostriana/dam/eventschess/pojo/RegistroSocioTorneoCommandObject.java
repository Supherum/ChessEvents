package com.salesianostriana.dam.eventschess.pojo;


/**
 * Objeto que nos ayuda a coger los ids de ambas entidades para poder hacer el formulario con ellas
 * @author Pablo Repiso Sasiain
 *
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroSocioTorneoCommandObject 
{
		
	private long socio_id;
	private long torneo_id;
}
