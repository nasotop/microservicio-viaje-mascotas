package com.viajes_mascotas.viajes_mascotas.services.interfaces;

import java.util.List;

import com.viajes_mascotas.viajes_mascotas.dto.TravelDto;

public interface ITravelSvc {
    /**
     * Metodo para consultar un viaje por id
     * 
     * @param id id del viaje
     * @return DTO del viaje
     * @throws Exception
     */
    TravelDto getById(Long id) throws Exception;

    /**
     * Metodo para consultar todos los viajes
     * 
     * @return lista de todos los viajes
     */
    List<TravelDto> getAll();

    /**
     * Metodo para crear un viaje
     * 
     * @param travel objeto por crear
     * @return objeto creado
     * @throws Exception
     */
    TravelDto create(TravelDto travel) throws Exception;

    /**
     * Metodo para actualizar un viaje
     * 
     * @param travel objeto por actualizar
     * @param id     id del viaje
     * @return objeto actualizado
     * @throws Exception
     */
    TravelDto update(TravelDto travel, Long id) throws Exception;

    /**
     * Metodo para eliminar un viaje
     * 
     * @param id id del viaje
     * @throws Exception
     */
    void delete(Long id) throws Exception;

}