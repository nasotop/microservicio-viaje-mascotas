package com.viajes_mascotas.viajes_mascotas.services.interfaces;

import com.viajes_mascotas.viajes_mascotas.dto.LoginDto;

public interface ILoginSvc {
    LoginDto LoginWithCredentials(String email, String password);
}
