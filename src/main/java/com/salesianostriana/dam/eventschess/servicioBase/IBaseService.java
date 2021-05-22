package com.salesianostriana.dam.eventschess.servicioBase;

import java.util.List;
/**
 * Interfaz maravillosa que implementamos y tiene los métodos que vamos a usar de normal
 * @author Pablo
 *
 * @param <T> Genérico del tipo que se usa (Objeto, Socio, Torneo,Persona)
 * @param <ID> Genérico de la clave primaria (id)
 */
public interface IBaseService<T, ID> {

	T save(T t);

	T findById(ID id);
	
	List<T> findAll();

	T edit(T t);

	void delete(T t);

	void deleteById(ID id);

}