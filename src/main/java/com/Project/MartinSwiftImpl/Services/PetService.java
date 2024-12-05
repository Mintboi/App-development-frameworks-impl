// PetService.java
package com.Project.MartinSwiftImpl.Services;

import com.Project.MartinSwiftImpl.DTOs.PetDTO;
import com.Project.MartinSwiftImpl.Objects.Pet;

import java.util.List;

public interface PetService {
    PetDTO createPet(PetDTO petDTO);
    PetDTO getPetById(Long id);
    List<PetDTO> getAllPets();
    PetDTO updatePet(Long id, PetDTO petDTO);
    void deletePet(Long id);
}
