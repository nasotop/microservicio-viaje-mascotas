package com.viajes_mascotas.viajes_mascotas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viajes_mascotas.viajes_mascotas.dto.GenericSingleResponseDto;
import com.viajes_mascotas.viajes_mascotas.dto.LoginDto;
import com.viajes_mascotas.viajes_mascotas.dto.UserCredentials;
import com.viajes_mascotas.viajes_mascotas.mapper.GenericResponseMapper;
import com.viajes_mascotas.viajes_mascotas.services.interfaces.ILoginSvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/login")
public class LoginController {
    @Autowired
    private ILoginSvc _loginSvc;

    @PostMapping
    public GenericSingleResponseDto<LoginDto> loginUser(@RequestBody UserCredentials credentials) {
        GenericSingleResponseDto<LoginDto> response = new GenericSingleResponseDto<LoginDto>();

        try {
            response = GenericResponseMapper
                    .ToGenericSingleResponseDto(
                            _loginSvc.LoginWithCredentials(credentials.getEmail(), credentials.getPassword()));
        } catch (Exception ex) {
            response.loadError(ex.getMessage());
        }
        return response;
    }

}
