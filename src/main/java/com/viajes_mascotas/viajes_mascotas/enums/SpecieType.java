package com.viajes_mascotas.viajes_mascotas.enums;

public enum SpecieType {
    DOG(1),
    CAT(2),
    BIRD(3);

    private final int value;

    SpecieType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public static SpecieType fromValue(int value) {
        for (SpecieType role : SpecieType.values()) {
            if (role.value == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Valor no válido para UserType: " + value);
    }
}
