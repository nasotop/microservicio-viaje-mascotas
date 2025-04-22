package com.viajes_mascotas.viajes_mascotas.dto;

import com.viajes_mascotas.viajes_mascotas.enums.SpecieType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {
    private Long id;
    private String name;
    private SpecieType type;
}
