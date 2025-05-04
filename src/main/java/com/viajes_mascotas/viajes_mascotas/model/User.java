package com.viajes_mascotas.viajes_mascotas.model;

import java.util.List;

import com.viajes_mascotas.viajes_mascotas.enums.UserType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType type;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets;
    @ManyToMany(mappedBy = "participants")
    private List<Travel> travel;

    @PreRemove
    private void preRemove() {
        for (Travel travel : this.travel) {
            travel.getParticipants().remove(this);
        }

        for (Pet pet : this.pets) {
            if (!pet.getOwner().equals(this))
                continue;
            pet.setOwner(null);
        }
    }

}
