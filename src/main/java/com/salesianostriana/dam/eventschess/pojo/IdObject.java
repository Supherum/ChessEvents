package com.salesianostriana.dam.eventschess.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdObject 
{
	
	@Id
	@GeneratedValue
	private long id;
	
	private long socio_id;
	private long torneo_id;
}
