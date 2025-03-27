package com.viajes_mascotas.viajes_mascotas.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@AllArgsConstructor
@Builder
public class GenericResponseDto<T> {
    private boolean Status;
    private String ErrorMessage;
    private List<T> Content;  
    
    public GenericResponseDto(){
        Status = true;
    }

    public void loadError(String errorMessage){
        Status = false;
        ErrorMessage =  errorMessage;
    }

}