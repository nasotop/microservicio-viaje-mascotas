package com.viajes_mascotas.viajes_mascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viajes_mascotas.viajes_mascotas.model.Pet;

public interface PetRepository extends JpaRepository<Pet,Long>{

}
