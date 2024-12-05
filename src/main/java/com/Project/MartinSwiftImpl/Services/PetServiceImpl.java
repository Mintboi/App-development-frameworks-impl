// PetServiceImpl.java
package com.Project.MartinSwiftImpl.Services;

import com.Project.MartinSwiftImpl.DTOs.PetDTO;
import com.Project.MartinSwiftImpl.Objects.Pet;
import com.Project.MartinSwiftImpl.Repositories.PetRepository;
import com.Project.MartinSwiftImpl.Services.PetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public PetDTO createPet(PetDTO petDTO) {
        return null;
    }

    @Override
    public PetDTO getPetById(Long id) {
        return null;
    }

    @Override
    public List<PetDTO> getAllPets() {
        return null;
    }

    @Override
    public PetDTO updatePet(Long id, PetDTO petDTO) {
        return null;
    }

    @Override
    public void deletePet(Long id) {

    }
}
