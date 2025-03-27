package com.viajes_mascotas.viajes_mascotas.mapper;

import java.util.List;

import com.viajes_mascotas.viajes_mascotas.dto.GenericResponseDto;
import com.viajes_mascotas.viajes_mascotas.dto.GenericSingleResponseDto;

public class GenericResponseMapper {
    public static <T> GenericResponseDto<T> ToGenericResponseDto(List<T> elements){
        GenericResponseDto<T> response = new GenericResponseDto<T>();
        response.setContent(elements);
        return response;
    }

    public static <T> GenericSingleResponseDto<T> ToGenericSingleResponseDto(T element){
        GenericSingleResponseDto<T> response = new GenericSingleResponseDto<T>();
        response.setContent(element);
        return response;
    }
}
