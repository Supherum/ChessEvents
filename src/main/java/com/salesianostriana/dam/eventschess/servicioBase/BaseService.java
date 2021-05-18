package com.salesianostriana.dam.eventschess.servicioBase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> implements IBaseService<T, ID> {

	
	protected R repositorio;
	
	public BaseService(R repo) {
		this.repositorio = repo;
	}
	
	public T save(T t) {
		return repositorio.save(t);
	}
	
	public T findById(ID id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public List<T> findAll() {
		return repositorio.findAll();
	}
	
	public T edit(T t) {
		return repositorio.save(t);
	}
	
	public void delete(T t) {
		repositorio.delete(t);
	}
	
	public void deleteById(ID id) {
		repositorio.deleteById(id);
	}
	
	
}
