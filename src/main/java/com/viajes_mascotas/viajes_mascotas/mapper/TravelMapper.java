package com.viajes_mascotas.viajes_mascotas.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.viajes_mascotas.viajes_mascotas.dto.TravelDto;
import com.viajes_mascotas.viajes_mascotas.model.Travel;

public class TravelMapper {
    public static TravelDto toDto(Travel entity) {
        return TravelDto.builder()
                .destination(entity.getDestination())
                .origin(entity.getOrigin())
                .pets(PetMapper.toDtos(entity.getPets()))
                .participants(UserMapper.toDtos(entity.getParticipants()))
                .build();
    }

    public static List<TravelDto> toDtos(List<Travel> entities) {
        return entities.stream().map(TravelMapper::toDto).collect(Collectors.toList());
    }
    public static Travel toEntity(TravelDto dto) {
        return Travel.builder()
                .destination(dto.getDestination())
                .origin(dto.getOrigin())
                .pets(PetMapper.toEntities(dto.getPets()))
                .participants(UserMapper.toEntities(dto.getParticipants()))
                .build();
    }

    public static List<Travel> toEntities(List<TravelDto> dtos) {
        return dtos.stream().map(TravelMapper::toEntity).collect(Collectors.toList());
    }
}
