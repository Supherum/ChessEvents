package com.salesianostriana.dam.eventschess.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * Clase que se encarga de modelar como es un Torneo en esta aplicación, también contiene algunos métodos
 * para facilitar el funcionamiento. Tiene una asociación muchos a muchos con Socios y es el lado NO propietario
 * @author Pablo Repiso Sasiain
 * @since 15/05/2021
 * @version 1.0V
 */
public class Torneo
{	
	/* Primary key */
	@Id
	@GeneratedValue
	private long id;
	
	/* INTERRELACIÓN */
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy="torneos", fetch = FetchType.EAGER)
	private List<Socio> socios = new ArrayList<>();
	
	/* Datos de un torneo */
	private String nombre;
	private String lugar;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha_comienzo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha_fin;
	
	@Enumerated
	private TipoPartida tipoPartida;
	
	private int participantes_maximos;
	private int rating_minimo;
	private String texto_aclarativo;
	

	public void addSocio(Socio s) {
		this.socios.add(s);
	}
	
	public void deleteSocio(Socio s) {
		this.socios.remove(s);
	}

	
	
}
