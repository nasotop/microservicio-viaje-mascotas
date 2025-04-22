package com.viajes_mascotas.viajes_mascotas.services.interfaces;

import java.util.List;

import com.viajes_mascotas.viajes_mascotas.dto.PetDto;

public interface IPetSvc {
    /**
     * Metodo para consutar una mascota por id
     * 
     * @param id id de la mascota
     * @return DTO de la mascota
     * @throws Exception
     */
    PetDto getById(Long id) throws Exception;

    /**
     * Metodo para consultar todas las mascotas
     * 
     * @return lista de mascotas
     */
    List<PetDto> getAll();

    /**
     * Metodo para consultar las mascotas de un usuario
     * 
     * @param ownerId id del usuario dueño
     * @return devuelve la lista de mascotas de un usuario
     * @throws Exception
     */
    List<PetDto> getAllByOwner(Long ownerId) throws Exception;

    /**
     * Metodo para actualizar una mascota
     * 
     * @param dto objeto por actualizar
     * @param id  id de la mascota
     * @return objeto actualizado
     * @throws Exception
     */
    PetDto update(PetDto dto, Long id) throws Exception;

    /**
     * Metodo para crear una mascota
     * 
     * @param pet     objeto por crear
     * @param ownerId id del dueño de la mascota
     * @return objeto creado
     * @throws Exception
     */
    PetDto create(PetDto pet, Long ownerId) throws Exception;

    /**
     * Metodo para eliminar una mascota
     * 
     * @param petId id de la mascota
     * @throws Exception
     */
    void delete(Long petId) throws Exception;

}