package com.viajes_mascotas.viajes_mascotas.services.implement;

import java.util.List;

import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.viajes_mascotas.viajes_mascotas.dto.PetDto;
import com.viajes_mascotas.viajes_mascotas.mapper.PetMapper;
import com.viajes_mascotas.viajes_mascotas.model.Pet;
import com.viajes_mascotas.viajes_mascotas.repository.PetRepository;
import com.viajes_mascotas.viajes_mascotas.repository.UserRepository;
import com.viajes_mascotas.viajes_mascotas.services.interfaces.IPetSvc;

@Service
public class PetSvcImpl implements IPetSvc {
    @Autowired
    private PetRepository _petRepository;
    @Autowired
    private UserRepository _userRepository;

    @Override
    public PetDto getById(Long id) throws Exception {
        var pet = _petRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró la mascota con el id " + id));

        return PetMapper.toDto(pet);
    }

    @Override
    public List<PetDto> getAll() {
        return PetMapper.toDtos(_petRepository.findAll());
    }

    @Override
    public List<PetDto> getAllByOwner(Long ownerId) throws Exception {
        var owner = _userRepository.findById(ownerId)
                .orElseThrow(() -> new Exception("No se econtró un dueño con el id  " + ownerId));

        var probe = Pet.builder().owner(owner).build();

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreNullValues();

        Example<Pet> example = Example.of(probe, matcher);

        var pets = _petRepository.findAll(example);

        if (pets.isEmpty()) {
            throw new Exception("No se encontraron mascotas asociadas al dueño " + ownerId);
        }
        return PetMapper.toDtos(pets);
    }

    @Override
    public PetDto update(PetDto dto, Long id) throws Exception {
        var entity = _petRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró la mascota " + id));

        entity.setName(dto.getName());
        
        entity.setType(dto.getType());

        return PetMapper.toDto(_petRepository.save(entity));
    }

    @Override
    public PetDto create(PetDto pet, Long ownerId) throws Exception {
        var owner = _userRepository.findById(ownerId)
                .orElseThrow(() -> new Exception("No se econtró un dueño con el id  " + ownerId));

        if (!owner.getType().equals(com.viajes_mascotas.viajes_mascotas.enums.UserType.PetOwner)) {
            throw new Exception("El usuario debe ser del tipo Dueño");
        }

        var entity = PetMapper.toEntity(pet);
        entity.setOwner(owner);

        return PetMapper.toDto(_petRepository.save(entity));
    }

    @Override
    public void delete(Long petId) throws Exception {
        if (!_petRepository.existsById(petId)) {
            throw new Exception("No se encontró la mascota con el id " + petId);
        }

        _petRepository.deleteById(petId);
    }

}
