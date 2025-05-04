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
import com.viajes_mascotas.viajes_mascotas.dto.PetDto;
import com.viajes_mascotas.viajes_mascotas.mapper.GenericResponseMapper;
import com.viajes_mascotas.viajes_mascotas.services.interfaces.IPetSvc;

@RestController
@RequestMapping("api/pets")
public class PetController {
    @Autowired
    private IPetSvc _petSvc;

    @GetMapping
    public GenericResponseDto<PetDto> getAllPets() {
        GenericResponseDto<PetDto> result = new GenericResponseDto<>();

        try {
            result = GenericResponseMapper.ToGenericResponseDto(_petSvc.getAll());
        } catch (Exception ex) {
            result.loadError(ex.getMessage());
        }
        return result;
    }

    @GetMapping("/get-by-owner/{owner-id}")
    public GenericResponseDto<PetDto> getAllPetsByOwner(@PathVariable("owner-id") Long ownerId) {
        GenericResponseDto<PetDto> result = new GenericResponseDto<>();

        try {
            result = GenericResponseMapper.ToGenericResponseDto(_petSvc.getAllByOwner(ownerId));
        } catch (Exception ex) {
            result.loadError(ex.getMessage());
        }
        return result;
    }

    @GetMapping("/{id}")
    public GenericSingleResponseDto<PetDto> getPetById(@PathVariable("id") Long id) {
        GenericSingleResponseDto<PetDto> result = new GenericSingleResponseDto<>();

        try {
            result = GenericResponseMapper.ToGenericSingleResponseDto(_petSvc.getById(id));
        } catch (Exception ex) {
            result.loadError(ex.getMessage());
        }
        return result;
    }

    @PostMapping("/create/{owner-id}")
    public GenericSingleResponseDto<PetDto> createPet(@RequestBody PetDto dto, @PathVariable("owner-id") Long ownerId) {
        GenericSingleResponseDto<PetDto> result = new GenericSingleResponseDto<>();

        try {
            result = GenericResponseMapper.ToGenericSingleResponseDto(_petSvc.create(dto, ownerId));
        } catch (Exception ex) {
            result.loadError(ex.getMessage());
        }
        return result;
    }

    @PostMapping("/update/{id}")
    public GenericSingleResponseDto<PetDto> updatePet(@RequestBody PetDto dto, @PathVariable("id") Long id) {
        GenericSingleResponseDto<PetDto> result = new GenericSingleResponseDto<>();

        try {
            result = GenericResponseMapper.ToGenericSingleResponseDto(_petSvc.update(dto, id));
        } catch (Exception ex) {
            result.loadError(ex.getMessage());
        }
        return result;
    }

    @PutMapping("/delete/{id}")
    public GenericSingleResponseDto<String> deletePet(@PathVariable("id") Long id) {
        GenericSingleResponseDto<String> result = new GenericSingleResponseDto<>();
        try {
            _petSvc.delete(id);

            result.setContent("Se elimino la mascota de forma exitosa");
        } catch (Exception ex) {
            result.loadError(ex.getMessage());

        }
        return result;
    }
}
