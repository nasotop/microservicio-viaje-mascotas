package com.viajes_mascotas.viajes_mascotas.services.interfaces;

import java.util.List;

import com.viajes_mascotas.viajes_mascotas.dto.UserDto;

public interface IUserSvc {
    /**
     * Metodo para consultar usuario por id
     * 
     * @param id id del usuario
     * @return devuelve DTO de usuario
     * @throws Exception arroja error en caso de que no exista un usuario asociado
     *                   al id consultado
     */
    UserDto getById(Long id) throws Exception;

    /**
     * Metodo para conseguir la lista de todos los usuarios
     * 
     * @return devuelve una lista de todos los usuarios disponibles
     */
    List<UserDto> getAllUsers();

    /**
     * Metodo para consultar los usuarios asociados a un tipo de usuario especifico
     * 
     * @param typeId
     * @return Devuelve una lista de usuarios o null en caso de que no haya ni un
     *         usuario asociado al tipo
     */
    List<UserDto> getUsersByType(int typeId);

    /**
     * Metodo para crear un usuario
     * 
     * @param dto objeto por crear
     * @return objeto creado
     */
    UserDto createUser(UserDto dto);

    /**
     * Metodo para actualizar un usuario
     * 
     * @param dto objeto para actualizar
     * @param id  id del objeto para actualizar
     * @return objeto actualizado
     * @throws Exception
     */
    UserDto updateUser(UserDto dto, Long id) throws Exception;

    /**
     * Metodo para eliminar un usuario
     * 
     * @param id id del usuario para eliminar
     * @throws Exception
     */
    void deleteUser(Long id) throws Exception;
}
