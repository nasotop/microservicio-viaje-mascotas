package com.viajes_mascotas.viajes_mascotas.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.viajes_mascotas.viajes_mascotas.dto.UserDto;
import com.viajes_mascotas.viajes_mascotas.enums.UserType;
import com.viajes_mascotas.viajes_mascotas.mapper.UserMapper;
import com.viajes_mascotas.viajes_mascotas.model.User;
import com.viajes_mascotas.viajes_mascotas.repository.UserRepository;
import com.viajes_mascotas.viajes_mascotas.services.interfaces.IUserSvc;

@Service
public class UserSvcImpl implements IUserSvc {
    @Autowired
    private UserRepository _userRepository;

    public List<UserDto> getAllUsers() {
        return UserMapper.toDtos(_userRepository.findAll());
    }

    @Override
    public UserDto getById(Long id) throws Exception {
        UserDto result = null;

        var user = _userRepository.findById(id).orElseThrow(() -> new Exception("No se encontró el usuario: " + id));

        result = UserMapper.toDto(user);

        return result;
    }

    @Override
    public List<UserDto> getUsersByType(int typeId) {

        List<UserDto> result = null;

        UserType userType = UserType.fromValue(typeId);

        var probe = User.builder().type(userType).build();

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreNullValues();

        Example<User> example = Example.of(probe, matcher);

        var users = UserMapper.toDtos(_userRepository.findAll(example));

        if (!users.isEmpty())
            result = users;

        return result;

    }

    @Override
    public UserDto createUser(UserDto dto) {

        var entity = UserMapper.toEntity(dto);

        return UserMapper.toDto(_userRepository.save(entity));

    }

    @Override
    public UserDto updateUser(UserDto dto, Long id) throws Exception {

        if (!_userRepository.existsById(id)) {
            throw new Exception("No se encontró el usuario " + id);
        }

        var entity = UserMapper.toEntity(dto);

        entity.setId(id);

        return UserMapper.toDto(_userRepository.save(entity));

    }

    @Override
    public void deleteUser(Long id) throws Exception {

        if (!_userRepository.existsById(id)) {
            throw new Exception("No se encontró el usuario " + id);
        }
        
        _userRepository.deleteById(id);

    }
}
