package com.viajes_mascotas.viajes_mascotas.services.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.viajes_mascotas.viajes_mascotas.dto.LoginDto;
import com.viajes_mascotas.viajes_mascotas.mapper.UserMapper;
import com.viajes_mascotas.viajes_mascotas.model.User;
import com.viajes_mascotas.viajes_mascotas.repository.UserRepository;
import com.viajes_mascotas.viajes_mascotas.services.interfaces.ILoginSvc;

@Service
public class LoginSvcImpl implements ILoginSvc {

    @Autowired
    private UserRepository _userRepository;

    public LoginDto LoginWithCredentials(String email, String password) throws Exception {

        LoginDto result = LoginDto.builder().IsLogged(false).build();

        var probe = User.builder().email(email).password(password).build();

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreNullValues();

        Example<User> example = Example.of(probe, matcher);
        var user = _userRepository.findOne(example).orElseThrow(() -> new Exception("Credenciales invalidas"));

        var userDto = UserMapper.toDto(user);

        result.setUserData(userDto);

        result.setIsLogged(true);
        return result;
    }

}
