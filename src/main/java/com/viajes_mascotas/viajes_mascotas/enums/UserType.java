package com.viajes_mascotas.viajes_mascotas.enums;

public enum UserType {
    PetOwner(1),
    PetFriendlyDriver(2),
    Veterinary(3)
    ;
    
    private final int value;

    UserType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public static UserType fromValue(int value) {
        for (UserType role : UserType.values()) {
            if (role.value == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Valor no válido para UserType: " + value);
    }
}
