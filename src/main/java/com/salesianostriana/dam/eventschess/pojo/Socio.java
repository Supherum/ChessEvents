package com.salesianostriana.dam.eventschess.pojo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Socio
{
	/* Primary key */
	@Id
	@GeneratedValue
	private long id;
	
	/* INTERRELACIÓN */
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		joinColumns = @JoinColumn(name="socio_id"),
		inverseJoinColumns = @JoinColumn(name="torneo_id")
	)
	private List<Torneo> torneos = new ArrayList<>();
	
	
	/* Security */
	private String usuario;
	private String password;
	
	/* Private information */
	private String nombre;
	private String apellido;
	private String nacionalidad;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha_nacimiento;
	private String foto;
	
	@Enumerated 
	private Gender genero;
	
	/* Rating scores */
	private int rating_standard;
	private int rating_rapid;
	private int rating_blitz;
	
	
	
	 public void addDelete (Torneo t) {
		 this.torneos.remove(t);
		t.deleteSocio(this);
		t.setParticipantes_actuales(t.getParticipantes_actuales()-1);
	 }
	
	 public void addTorneo (Torneo t) {
		this.torneos.add(t);
		t.addSocio(this);
		t.setParticipantes_actuales(t.getParticipantes_actuales()+1);
	 }
	
	
	public Socio(String usuario, String password, String nombre, String apellido, String nacionalidad,
			LocalDate fecha_nacimiento, Gender genero, int rating_standard, int rating_rapid, int rating_blitz) {
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.fecha_nacimiento = fecha_nacimiento;
		this.genero = genero;
		this.rating_standard = rating_standard;
		this.rating_rapid = rating_rapid;
		this.rating_blitz = rating_blitz;
	}

	public Socio(String nombre, String apellido, String nacionalidad, LocalDate fecha_nacimiento, Gender genero,
			int rating_standard) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.fecha_nacimiento = fecha_nacimiento;
		this.genero = genero;
		this.rating_standard = rating_standard;
	}

	public Socio(String nombre, String apellido, String nacionalidad, LocalDate fecha_nacimiento, String foto,
			Gender genero, int rating_rapid) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.fecha_nacimiento = fecha_nacimiento;
		this.foto = foto;
		this.genero = genero;
		this.rating_rapid = rating_rapid;
	}

	
	
	
	
	
	
}
