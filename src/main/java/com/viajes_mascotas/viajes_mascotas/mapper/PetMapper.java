package com.viajes_mascotas.viajes_mascotas.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.viajes_mascotas.viajes_mascotas.dto.PetDto;
import com.viajes_mascotas.viajes_mascotas.model.Pet;

public class PetMapper {
    public static PetDto toDto(Pet entity){
        return PetDto.builder()
        .name(entity.getName())
        .type(entity.getType())
        .id(entity.getId())
        .build();
    }
    public static List<PetDto> toDtos(List<Pet> entities){
        return entities.stream().map(PetMapper::toDto).collect(Collectors.toList());
    }
    public static Pet toEntity(PetDto dto){
        return Pet.builder()
        .name(dto.getName())
        .type(dto.getType())
        .id(dto.getId())
        .build();
    }
    public static List<Pet> toEntities(List<PetDto> dtos){
        return dtos.stream().map(PetMapper::toEntity).collect(Collectors.toList());
    }
}
