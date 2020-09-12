package mermody.springframework.petclinic.services;

import mermody.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findbyId(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
