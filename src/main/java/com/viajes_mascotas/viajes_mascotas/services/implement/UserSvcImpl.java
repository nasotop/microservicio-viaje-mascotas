package com.viajes_mascotas.viajes_mascotas.services.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viajes_mascotas.viajes_mascotas.dto.UserDto;
import com.viajes_mascotas.viajes_mascotas.mapper.UserMapper;
import com.viajes_mascotas.viajes_mascotas.repository.implement.UserRepositoryImpl;
import com.viajes_mascotas.viajes_mascotas.repository.interfaces.IUserRepository;
import com.viajes_mascotas.viajes_mascotas.services.interfaces.IUserSvc;
@Service
public class UserSvcImpl implements IUserSvc{
    
    private final IUserRepository _userRepository;

    public UserSvcImpl(UserRepositoryImpl userRepositoryImpl){
        _userRepository = userRepositoryImpl;
    }

    public List<UserDto> getAllUsers(){
        return UserMapper.toDtos(_userRepository.getAll());
    } 

    public UserDto getById(int id) throws Exception {
        UserDto result =  null;

        var user =  _userRepository.getById(id);

        if(user == null) throw new Exception("No se encontró el usuario: "+id);

        result =  UserMapper.toDto(user);

        return result;
    }
}
