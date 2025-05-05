package com.viajes_mascotas.viajes_mascotas.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viajes_mascotas.viajes_mascotas.dto.TravelDto;
import com.viajes_mascotas.viajes_mascotas.enums.UserType;
import com.viajes_mascotas.viajes_mascotas.mapper.TravelMapper;
import com.viajes_mascotas.viajes_mascotas.model.Pet;
import com.viajes_mascotas.viajes_mascotas.repository.TravelRepository;
import com.viajes_mascotas.viajes_mascotas.services.interfaces.ITravelSvc;

@Service
public class TravelSvcImpl implements ITravelSvc {
    @Autowired
    private TravelRepository _travelRepository;

    @Override
    public TravelDto getById(Long id) throws Exception {
        var entity = _travelRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontraró un viaje con el id " + id));

        return TravelMapper.toDto(entity);
    }

    @Override
    public List<TravelDto> getAll() {
        return TravelMapper.toDtos(_travelRepository.findAll());
    }

    @Override
    public TravelDto create(TravelDto travel) throws Exception {
        if (travel.getPets().isEmpty()) {
            throw new Exception("Debe asignar al menos una mascota al viaje");
        }

        if (travel.getParticipants().isEmpty()) {
            throw new Exception("Debe asignar al menos un participante al viaje");
        }

        if (travel.getParticipants().stream().filter((u -> u.getType().equals(UserType.PetOwner))).count() != 1) {
            throw new Exception("Debe asignar un participante al viaje que sea el dueño de la mascota");

        }
        var entity = TravelMapper.toEntity(travel);
        var owner = entity.getParticipants().stream().filter(f -> f.getType().equals(UserType.PetOwner)).findFirst()
                .get();

        for (Pet pet : entity.getPets()) {
            pet.setOwner(owner);
        }

        return TravelMapper.toDto(_travelRepository.save(entity));
    }

    @Override
    public TravelDto update(TravelDto travel, Long id) throws Exception {
        if (!_travelRepository.existsById(id)) {
            throw new Exception("No se encontró un viaje con el id " + id);
        }
        if (travel.getParticipants().isEmpty()) {
            throw new Exception("Debe asignar al menos un participante al viaje");
        }

        if (travel.getParticipants().stream().filter((u -> u.getType().equals(UserType.PetOwner))).count() != 1) {
            throw new Exception("Debe asignar un participante al viaje que sea el dueño de la mascota");

        }
        var entity = TravelMapper.toEntity(travel);

        entity.setId(id);

        var owner = entity
                .getParticipants()
                .stream()
                .filter(f -> f.getType().equals(UserType.PetOwner))
                .findFirst()
                .get();

        for (Pet pet : entity.getPets()) {
            pet.setOwner(owner);
        }
        return TravelMapper.toDto(_travelRepository.save(entity));
    }

    @Override
    @Transactional

    public void delete(Long id) throws Exception {
        if (!_travelRepository.existsById(id)) {
            throw new Exception("No se encontró un viaje con el id " + id);
        }
        _travelRepository.deleteById(id);
    }

}
