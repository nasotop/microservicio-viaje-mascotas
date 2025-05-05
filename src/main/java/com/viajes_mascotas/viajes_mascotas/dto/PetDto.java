package com.viajes_mascotas.viajes_mascotas.dto;

import org.springframework.hateoas.RepresentationModel;

import com.viajes_mascotas.viajes_mascotas.enums.SpecieType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(callSuper=false)

@NoArgsConstructor
@AllArgsConstructor
public class PetDto extends RepresentationModel<PetDto> {
    private Long id;
    private String name;
    private SpecieType type;
}
