package com.viajes_mascotas.viajes_mascotas.model;

import java.util.List;

import com.viajes_mascotas.viajes_mascotas.enums.SpecieType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pet") 
public class Pet {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    private SpecieType type;
    @ManyToOne
    @JoinColumn(name= "owner_id")
    private User owner;
    @ManyToMany(mappedBy = "pets")
    private List<Travel> travel;

      @PreRemove
    private void preRemove() {
        for (Travel travel : this.travel) {
            travel.getPets().remove(this);
        }
    }
}
