package com.salesianostriana.dam.eventschess.pojo;



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
