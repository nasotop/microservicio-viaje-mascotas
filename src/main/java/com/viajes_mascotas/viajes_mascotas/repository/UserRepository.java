package com.viajes_mascotas.viajes_mascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viajes_mascotas.viajes_mascotas.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
