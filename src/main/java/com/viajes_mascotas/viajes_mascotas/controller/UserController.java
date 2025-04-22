package com.viajes_mascotas.viajes_mascotas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.viajes_mascotas.viajes_mascotas.dto.GenericResponseDto;
import com.viajes_mascotas.viajes_mascotas.dto.GenericSingleResponseDto;
import com.viajes_mascotas.viajes_mascotas.dto.UserDto;
import com.viajes_mascotas.viajes_mascotas.mapper.GenericResponseMapper;
import com.viajes_mascotas.viajes_mascotas.services.interfaces.IUserSvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private IUserSvc _userSvc;

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
    public GenericSingleResponseDto<UserDto> getUserById(@PathVariable("id") Long id) {
        GenericSingleResponseDto<UserDto> result = new GenericSingleResponseDto<>();

        try {

            result = GenericResponseMapper.ToGenericSingleResponseDto(_userSvc.getById(id));

        } catch (Exception ex) {

            result.loadError(ex.getMessage());

        }

        return result;
    }


    @GetMapping("/get-by-type/{id-tipo}")
    public GenericResponseDto<UserDto> getUsersByType(@PathVariable("id-tipo") int idtipo) {
        GenericResponseDto<UserDto> result = new GenericResponseDto<>();
        try {

            result = GenericResponseMapper.ToGenericResponseDto(_userSvc.getUsersByType(idtipo));

        } catch (Exception ex) {

            result.loadError(ex.getMessage());

        }

        return result;
    }

    @PostMapping("/create")
    public GenericSingleResponseDto<UserDto> createUser(@RequestBody UserDto dto) {
        GenericSingleResponseDto<UserDto> result = new GenericSingleResponseDto<>();
        try {
            result = GenericResponseMapper.ToGenericSingleResponseDto(_userSvc.createUser(dto));
        } catch (Exception ex) {
            result.loadError(ex.getMessage());

        }
        return result;
    }

    @PostMapping("/update/{id}")
    public GenericSingleResponseDto<UserDto> updateUser(@RequestBody UserDto dto, @PathVariable("id") Long id) {
        GenericSingleResponseDto<UserDto> result = new GenericSingleResponseDto<>();
        try {
            result = GenericResponseMapper.ToGenericSingleResponseDto(_userSvc.updateUser(dto, id));
        } catch (Exception ex) {
            result.loadError(ex.getMessage());

        }
        return result;
    }

    @PutMapping("/delete/{id}")
    public GenericSingleResponseDto<String> deleteUser(@PathVariable("id") Long id) {
        GenericSingleResponseDto<String> result = new GenericSingleResponseDto<>();
        try {
            _userSvc.deleteUser(id);

            result.setContent("Se elimino el usuario de forma exitosa");
        } catch (Exception ex) {
            result.loadError(ex.getMessage());

        }
        return result;
    }
}
