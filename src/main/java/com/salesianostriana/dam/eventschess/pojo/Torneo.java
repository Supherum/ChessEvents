package com.salesianostriana.dam.eventschess.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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
	private TipoPartida tipo_partida;
	private int participantes_maximos;
	private int participantes_actuales;
	private int rating_minimo;
	private String texto_aclarativo;
	
	
	public Torneo(String nombre, String lugar, LocalDate fecha_comienzo, LocalDate fecha_fin, TipoPartida tipo_partida,
			int participantes_maximos, int participantes_actuales) {
		this.nombre = nombre;
		this.lugar = lugar;
		this.fecha_comienzo = fecha_comienzo;
		this.fecha_fin = fecha_fin;
		this.tipo_partida = tipo_partida;
		this.participantes_maximos = participantes_maximos;
		this.participantes_actuales = participantes_actuales;
	}


	public Torneo(String nombre, String lugar, LocalDate fecha_comienzo, LocalDate fecha_fin, TipoPartida tipo_partida,
			int participantes_maximos, int rating_minimo, String texto_aclarativo) {
		this.nombre = nombre;
		this.lugar = lugar;
		this.fecha_comienzo = fecha_comienzo;
		this.fecha_fin = fecha_fin;
		this.tipo_partida = tipo_partida;
		this.participantes_maximos = participantes_maximos;
		this.rating_minimo = rating_minimo;
		this.texto_aclarativo = texto_aclarativo;
	}
	
	
	
}
