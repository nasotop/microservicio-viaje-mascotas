package com.viajes_mascotas.viajes_mascotas.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "travel") 
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private String origin;
    private String destination;

    @ManyToMany( cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name="travel_participants",
     joinColumns = @JoinColumn(name="travel_id",
     referencedColumnName = "id"),
     inverseJoinColumns = @JoinColumn(name="user_id",
     referencedColumnName = "id") )
    private List<User> participants;

    @ManyToMany( cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name="travel_pets",
    joinColumns = @JoinColumn(name="travel_id"),
    inverseJoinColumns = @JoinColumn(name="pet_id"))
    private List<Pet> pets;
}
