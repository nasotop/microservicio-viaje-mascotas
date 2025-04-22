package com.viajes_mascotas.viajes_mascotas.services.interfaces;

import com.viajes_mascotas.viajes_mascotas.dto.LoginDto;

public interface ILoginSvc {
    /**
     * Metodo para consultar un usuario por credenciales
     * 
     * @param email    correo asociado al usuario
     * @param password contraseña asociada al usuario
     * @return devuelve un DTO de la información de Login
     */
    LoginDto LoginWithCredentials(String email, String password) throws Exception;
}
