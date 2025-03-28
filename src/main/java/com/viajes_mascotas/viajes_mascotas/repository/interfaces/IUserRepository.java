package com.viajes_mascotas.viajes_mascotas.repository.interfaces;

import java.util.List;

import com.viajes_mascotas.viajes_mascotas.model.User;

public interface IUserRepository {
    /**
     * Metodo para consultar un usuario por id
     * 
     * @param id id del usuario
     * @return devuelve una entidad de usuario
     */
    User getById(int id);

    /**
     * Metodo para consultar un usuario por credenciales
     * 
     * @param email    correo del usuario
     * @param password contraseña del usuario
     * @return devuelve una entidad de usuario
     */
    User getByCredentials(String email, String password);

    /**
     * Metodo para conseguir la lista completa de usuarios
     * 
     * @return devuelve una lista de usuarios
     */
    List<User> getAll();
}
