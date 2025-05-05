package com.viajes_mascotas.viajes_mascotas.dto;

import org.springframework.hateoas.RepresentationModel;

import com.viajes_mascotas.viajes_mascotas.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto extends RepresentationModel<UserDto>  {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private UserType type;
    
}
