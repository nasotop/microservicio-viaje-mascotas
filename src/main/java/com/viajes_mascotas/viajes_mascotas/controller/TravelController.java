package com.viajes_mascotas.viajes_mascotas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viajes_mascotas.viajes_mascotas.dto.GenericResponseDto;
import com.viajes_mascotas.viajes_mascotas.dto.GenericSingleResponseDto;
import com.viajes_mascotas.viajes_mascotas.dto.TravelDto;
import com.viajes_mascotas.viajes_mascotas.mapper.GenericResponseMapper;
import com.viajes_mascotas.viajes_mascotas.services.interfaces.ITravelSvc;

@RestController
@RequestMapping("api/travels")
public class TravelController {
    @Autowired
    private ITravelSvc _travelSvc;

    @GetMapping
    public GenericResponseDto<TravelDto> getAllTravels() {
        GenericResponseDto<TravelDto> result = new GenericResponseDto<>();

        try {

            result = GenericResponseMapper.ToGenericResponseDto(_travelSvc.getAll());

        } catch (Exception ex) {

            result.loadError(ex.getMessage());

        }
        return result;
    }
    @GetMapping("/{id}")
    public GenericSingleResponseDto<TravelDto> getById(@PathVariable("id") Long id) {
        GenericSingleResponseDto<TravelDto> result = new GenericSingleResponseDto<>();

        try {

            result = GenericResponseMapper.ToGenericSingleResponseDto(_travelSvc.getById(id));

        } catch (Exception ex) {

            result.loadError(ex.getMessage());

        }
        return result;
    }

    @PostMapping("/create")
    public GenericSingleResponseDto<TravelDto> createTravel(@RequestBody TravelDto dto) {
        GenericSingleResponseDto<TravelDto> result = new GenericSingleResponseDto<>();
        try {
            result = GenericResponseMapper.ToGenericSingleResponseDto(_travelSvc.create(dto));
        } catch (Exception ex) {
            result.loadError(ex.getMessage());

        }
        return result;
    }

    @PostMapping("/update/{id}")
    public GenericSingleResponseDto<TravelDto> updateTravel(@RequestBody TravelDto dto, @PathVariable("id") Long id) {
        GenericSingleResponseDto<TravelDto> result = new GenericSingleResponseDto<>();
        try {
            result = GenericResponseMapper.ToGenericSingleResponseDto(_travelSvc.update(dto, id));
        } catch (Exception ex) {
            result.loadError(ex.getMessage());

        }
        return result;
    }

    @PutMapping("/delete/{id}")
    public GenericSingleResponseDto<String> deleteTravel(@PathVariable("id") Long id) {
        GenericSingleResponseDto<String> result = new GenericSingleResponseDto<>();
        try {
            _travelSvc.delete(id);

            result.setContent("Se elimino el viaje de forma exitosa");
        } catch (Exception ex) {
            result.loadError(ex.getMessage());

        }
        return result;
    }

}
