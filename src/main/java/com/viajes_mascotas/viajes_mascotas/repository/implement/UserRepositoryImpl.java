package com.viajes_mascotas.viajes_mascotas.repository.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.viajes_mascotas.viajes_mascotas.enums.UserType;
import com.viajes_mascotas.viajes_mascotas.model.User;
import com.viajes_mascotas.viajes_mascotas.repository.interfaces.IUserRepository;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private ArrayList<User> users = new ArrayList<User>();

    public UserRepositoryImpl() {
        users.add(User.builder()
                .Id(1)
                .FirstName("Juan")
                .SecondName("Pérez")
                .Email("juan.perez@example.com")
                .Password("securePass123")
                .Type(UserType.PetOwner)
                .build());

        users.add(User.builder()
                .Id(2)
                .FirstName("María")
                .SecondName("López")
                .Email("maria.lopez@example.com")
                .Password("pass456")
                .Type(UserType.PetOwner)
                .build());

        users.add(User.builder()
                .Id(3)
                .FirstName("Carlos")
                .SecondName("González")
                .Email("carlos.gonzalez@example.com")
                .Password("myPass789")
                .Type(UserType.PetFriendlyDriver)
                .build());

        users.add(User.builder()
                .Id(4)
                .FirstName("Ana")
                .SecondName("Fernández")
                .Email("ana.fernandez@example.com")
                .Password("anaPass321")
                .Type(UserType.PetFriendlyDriver)
                .build());

        users.add(User.builder()
                .Id(5)
                .FirstName("Pedro")
                .SecondName("Ramírez")
                .Email("pedro.ramirez@example.com")
                .Password("ramirezPass000")
                .Type(UserType.Veterinary)
                .build());
    }

    public List<User> getAll() {
        return users;
    }

    public User getById(int id) {
        User user = null;

        for (User item : users) {
            if (item.Id != id)
                continue;
            user = item;
        }

        return user;
    }

    public User getByCredentials(String email, String password) {
        User user = null;

        for (User item : users) {
            if (!item.Email.equals(email) || !item.Password.equals(password))
                continue;
            user = item;
        }

        return user;
    }
}
