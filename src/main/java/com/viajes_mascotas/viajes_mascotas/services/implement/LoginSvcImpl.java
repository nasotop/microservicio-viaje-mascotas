package com.viajes_mascotas.viajes_mascotas.services.implement;

import static com.viajes_mascotas.viajes_mascotas.dto.LoginDto.builder;

import org.springframework.stereotype.Service;

import com.viajes_mascotas.viajes_mascotas.dto.LoginDto;
import com.viajes_mascotas.viajes_mascotas.mapper.UserMapper;
import com.viajes_mascotas.viajes_mascotas.repository.implement.UserRepositoryImpl;
import com.viajes_mascotas.viajes_mascotas.repository.interfaces.IUserRepository;
import com.viajes_mascotas.viajes_mascotas.services.interfaces.ILoginSvc;
@Service
public class LoginSvcImpl implements ILoginSvc {
    
    private final IUserRepository _userRepository;

    public LoginSvcImpl(UserRepositoryImpl userRepositoryImpl)
    {
        _userRepository=userRepositoryImpl;
    }

    public LoginDto LoginWithCredentials(String email, String password){

        LoginDto result = builder().IsLogged(false).build();

        var user =  _userRepository.getByCredentials(email, password);
        
        if(user == null) return result;

        var userDto =  UserMapper.toDto(user);

        result.setUserData(userDto);
         
        result.setIsLogged(true);
        return result;
    }
    
}
