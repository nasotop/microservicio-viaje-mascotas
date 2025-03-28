package com.viajes_mascotas.viajes_mascotas.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GenericResponseDto<T> {
    private boolean status;
    private String errorMessage;
    private List<T> content;

    public GenericResponseDto() {
        status = true;
    }

    /**
     * Metodo para cargar un error a la respuesta
     * 
     * @param errorMessage mensaje de error
     */
    public void loadError(String errorMessage) {
        status = false;
        this.errorMessage = errorMessage;
    }

}