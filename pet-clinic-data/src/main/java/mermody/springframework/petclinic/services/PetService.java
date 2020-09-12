package mermody.springframework.petclinic.services;

import mermody.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findbyId(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
