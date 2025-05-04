package com.viajes_mascotas.viajes_mascotas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PetRepositoryTest {
    @Autowired
    private PetRepository _petRepository;

    @Test
    public void getPetByIdTest() {

        var result = _petRepository.findById(1L);

        assertEquals(result.isEmpty(), false);

    }

    @Test
    public void findAllTest() {

        var result = _petRepository.findAll();

        assertEquals(result.isEmpty(), false);

    }
}
