package com.viajes_mascotas.viajes_mascotas.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private Boolean IsLogged;

    private UserDto UserData;
}
