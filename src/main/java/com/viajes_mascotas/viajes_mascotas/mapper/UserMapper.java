package com.viajes_mascotas.viajes_mascotas.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.viajes_mascotas.viajes_mascotas.dto.UserDto;
import com.viajes_mascotas.viajes_mascotas.enums.UserType;
import com.viajes_mascotas.viajes_mascotas.helpers.LinkHelper;
import com.viajes_mascotas.viajes_mascotas.model.User;

public class UserMapper {
    /**
     * Metodo para mapear entidad usuario a DTO
     * 
     * @param entity entidad de usuario
     * @return devuelve DTO de usuario
     */
    public static UserDto toDto(User entity) {
        var dto = UserDto.builder()
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .type(entity.getType())
                .id(entity.getId())
                .password(entity.getPassword())
                .build();

        if (dto.getType().equals(UserType.PetOwner)) {
            dto.add(LinkHelper.ownerLink(dto.getId()));
        }

        return addLinks(dto);
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

    public static UserDto addLinks(UserDto dto) {

        return dto.add(LinkHelper.buildUserLinks(dto.getId()));
    }

    public static User toEntity(UserDto dto) {
        return User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .type(dto.getType())
                .id(dto.getId())
                .build();
    }

    public static List<User> toEntities(List<UserDto> dtos) {
        return dtos.stream()
                .map(UserMapper::toEntity)
                .collect(Collectors.toList());
    }
}
