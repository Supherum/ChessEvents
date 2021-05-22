package com.salesianostriana.dam.eventschess.servicioBase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
/**
 * Servicio Base que implementa la interfáz que nos permite hacer las peticiones básicas
 * con esta clase la extenderemos al resto para que no tengamos que hacer este servicio tantas veces
 * @author Pablo Repiso Sasiain (Ayuda insane de Luismiguel López)
 * @param <T> Es el Genérico de Tipo de objeto que creamos (Socio, Torneo,...)
 * @param <ID> Es el Genérico de clave primaria por el que guardará (Id de siempre)
 * @param <R>
 */
public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> implements IBaseService<T, ID> {

	/**
	 * Repositorio Genérico de cada uno
	 */
	protected R repositorio;
	
	
	/**
	 * Constructor base 
	 * @param repo Repositorio 
	 */
	public BaseService(R repo) {
		this.repositorio = repo;
	}
	
	/**
	 * Guarda objeto t en el repositorio
	 */
	public T save(T t) {
		return repositorio.save(t);
	}
	
	/**
	 * Busca el objeto t por su id
	 */
	public T findById(ID id) {
		return repositorio.findById(id).orElse(null);
	}
	
	/**
	 * Busca a todos los objetos del repositorio del tipo t
	 */
	public List<T> findAll() {
		return repositorio.findAll();
	}
	
	/**
	 * Guarda de nuevo el objeto t, se hace para diferenciar aunque sea lo mismo
	 */
	public T edit(T t) {
		return repositorio.save(t);
	}
	
	/**
	 * Borra un objeto t del repositorio
	 */
	public void delete(T t) {
		repositorio.delete(t);
	}
	
	/**
	 * Borra un objeto con u id del repositorio
	 */
	public void deleteById(ID id) {
		repositorio.deleteById(id);
	}
	
	
}
