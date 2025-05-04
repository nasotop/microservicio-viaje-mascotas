package com.viajes_mascotas.viajes_mascotas.helpers;

import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;

import com.viajes_mascotas.viajes_mascotas.controller.PetController;
import com.viajes_mascotas.viajes_mascotas.controller.TravelController;
import com.viajes_mascotas.viajes_mascotas.controller.UserController;
import com.viajes_mascotas.viajes_mascotas.dto.PetDto;
import com.viajes_mascotas.viajes_mascotas.dto.TravelDto;
import com.viajes_mascotas.viajes_mascotas.dto.UserDto;

public class LinkHelper {

    public static List<Link> buildPetLinks(long id) {
        return List.of(
                linkTo(methodOn(PetController.class).getPetById(id)).withRel("Get"),
                linkTo(methodOn(PetController.class).updatePet(new PetDto(), id)).withRel("Update"),
                linkTo(methodOn(PetController.class).deletePet(id)).withRel("Delete"));
    }

    public static List<Link> buildTravelLinks(long id) {
        return List.of(
                linkTo(methodOn(TravelController.class).getById(id)).withRel("Get"),
                linkTo(methodOn(TravelController.class).updateTravel(new TravelDto(), id)).withRel("Update"),
                linkTo(methodOn(TravelController.class).deleteTravel(id)).withRel("Delete"));
    }
    public static List<Link> buildUserLinks(long id) {
        return List.of(
                linkTo(methodOn(UserController.class).getUserById(id)).withRel("Get"),
                linkTo(methodOn(UserController.class).updateUser(new UserDto(), id)).withRel("Update"),
                linkTo(methodOn(UserController.class).deleteUser(id)).withRel("Delete"));
    }

    public static Link ownerLink(Long id){
        return linkTo(methodOn(PetController.class).getAllPetsByOwner(id)).withRel("Pets");
    }
}
