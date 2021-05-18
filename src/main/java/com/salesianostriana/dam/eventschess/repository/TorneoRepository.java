package com.salesianostriana.dam.eventschess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.eventschess.pojo.Torneo;

public interface TorneoRepository extends JpaRepository<Torneo,Long> {

}
