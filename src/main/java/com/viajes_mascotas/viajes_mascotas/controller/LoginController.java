package com.viajes_mascotas.viajes_mascotas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viajes_mascotas.viajes_mascotas.dto.GenericSingleResponseDto;
import com.viajes_mascotas.viajes_mascotas.dto.LoginDto;
import com.viajes_mascotas.viajes_mascotas.mapper.GenericResponseMapper;
import com.viajes_mascotas.viajes_mascotas.services.implement.LoginSvcImpl;
import com.viajes_mascotas.viajes_mascotas.services.interfaces.ILoginSvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/login")
public class LoginController {

    private final ILoginSvc _loginSvc;

    public LoginController(LoginSvcImpl loginSvcImpl) {
        _loginSvc = loginSvcImpl;
    }

    /**
     * Endpoint para consultar un usuario mediante credenciales
     * 
     * @param email    correo del usuario
     * @param password contraseña del usuario
     * @return devuelve un DTO con informacion del Login
     */
    @GetMapping
    public GenericSingleResponseDto<LoginDto> loginUser(@RequestParam("email") String email,
            @RequestParam("password") String password) {
        GenericSingleResponseDto<LoginDto> response = new GenericSingleResponseDto<LoginDto>();

        try {
            response = GenericResponseMapper
                    .ToGenericSingleResponseDto(_loginSvc.LoginWithCredentials(email, password));
        } catch (Exception ex) {
            response.loadError(ex.getMessage());
        }
        return response;
    }

}
