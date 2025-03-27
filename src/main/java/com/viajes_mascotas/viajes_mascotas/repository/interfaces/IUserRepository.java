package com.viajes_mascotas.viajes_mascotas.repository.interfaces;

import java.util.List;

import com.viajes_mascotas.viajes_mascotas.model.User;

public interface IUserRepository {
    User getById(int id);
    User getByCredentials(String email, String password);
    List<User> getAll();
}
