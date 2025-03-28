package com.viajes_mascotas.viajes_mascotas.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.viajes_mascotas.viajes_mascotas.dto.UserDto;
import com.viajes_mascotas.viajes_mascotas.model.User;

public class UserMapper {
    /**
     * Metodo para mapear entidad usuario a DTO
     * 
     * @param entity entidad de usuario
     * @return devuelve DTO de usuario
     */
    public static UserDto toDto(User entity) {
        return UserDto.builder()
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getSecondName())
                .type(entity.getType())
                .build();
    }

    /**
     * Metodo para mapear una lista de entidades de usuarios
     * 
     * @param entities lista de entidades
     * @return devuelve lista de DTOs de usuario
     */
    public static List<UserDto> toDtos(List<User> entities) {
        return entities.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }
}
