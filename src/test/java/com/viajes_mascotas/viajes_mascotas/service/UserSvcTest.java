package com.viajes_mascotas.viajes_mascotas.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.viajes_mascotas.viajes_mascotas.services.interfaces.IUserSvc;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserSvcTest {
    @Autowired
    private IUserSvc _userSvc;

    @Test
    public void getUsersByTypeTest() {
        var result = _userSvc.getUsersByType(1);
        assertEquals(result.isEmpty(), false);
    }

    
    @Test
    public void getUserByIdTest() {
      
        assertDoesNotThrow(()->  _userSvc.getById(1L), "El metodo deleteUser arrojó un error");
    }
}
