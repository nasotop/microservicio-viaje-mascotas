package com.viajes_mascotas.viajes_mascotas.dto;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelDto extends RepresentationModel<TravelDto> {
    private Long id;
    private String origin;
    private String destination;
    private List<PetDto> pets;
    private List<UserDto> participants;
}
