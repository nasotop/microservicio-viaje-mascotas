package com.viajes_mascotas.viajes_mascotas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

   @JsonProperty("isLogged")
    private Boolean IsLogged;

    @JsonProperty("userData")
    private UserDto UserData;
}
