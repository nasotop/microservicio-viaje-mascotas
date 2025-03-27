package com.viajes_mascotas.viajes_mascotas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.viajes_mascotas.viajes_mascotas.dto.GenericResponseDto;
import com.viajes_mascotas.viajes_mascotas.dto.GenericSingleResponseDto;
import com.viajes_mascotas.viajes_mascotas.dto.UserDto;
import com.viajes_mascotas.viajes_mascotas.mapper.GenericResponseMapper;
import com.viajes_mascotas.viajes_mascotas.services.implement.UserSvcImpl;
import com.viajes_mascotas.viajes_mascotas.services.interfaces.IUserSvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final IUserSvc _userSvc;

    public UserController(UserSvcImpl userSvcImpl) {
        _userSvc = userSvcImpl;
    }

    @GetMapping
    public GenericResponseDto<UserDto> getAllUsers() {
        GenericResponseDto<UserDto> result = new GenericResponseDto<>();

        try {

            result = GenericResponseMapper.ToGenericResponseDto(_userSvc.getAllUsers());

        } catch (Exception ex) {

            result.loadError(ex.getMessage());

        }
        return result;
    }

    @GetMapping("/{id}")
    public GenericSingleResponseDto<UserDto> getMethodName(@PathVariable("id") int id) {
        GenericSingleResponseDto<UserDto> result = new GenericSingleResponseDto<>();

        try {

            result = GenericResponseMapper.ToGenericSingleResponseDto(_userSvc.getById(id));

        } catch (Exception ex) {

            result.loadError(ex.getMessage());

        }

        return result;
    }

}
