package com.viajes_mascotas.viajes_mascotas.services.interfaces;

import java.util.List;

import com.viajes_mascotas.viajes_mascotas.dto.UserDto;

public interface IUserSvc {
    UserDto getById(int id)throws Exception;
    List<UserDto> getAllUsers();
}
