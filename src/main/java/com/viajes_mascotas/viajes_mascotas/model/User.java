package com.viajes_mascotas.viajes_mascotas.model;

import com.viajes_mascotas.viajes_mascotas.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    public int Id;
    public String FirstName;

    public String SecondName;

    public String Email;

    public String Password;

    public UserType Type;



}
