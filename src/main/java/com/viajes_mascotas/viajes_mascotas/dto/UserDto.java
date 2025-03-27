package com.viajes_mascotas.viajes_mascotas.dto;

import com.viajes_mascotas.viajes_mascotas.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    public String email;
    public String firstName;
    public String lastName;
    public UserType type;
}
