// PetGraphQLResolver.java
package com.Project.MartinSwiftImpl.Controllers;

import com.Project.MartinSwiftImpl.Objects.Pet;
import com.Project.MartinSwiftImpl.Repositories.PetRepository;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PetGraphQLResolver {

    private final PetRepository petRepository;

    public PetGraphQLResolver(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @QueryMapping
    public Pet getPetById(@Argument Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @MutationMapping
    public Pet createPet(@Argument String name, @Argument String type, @Argument Long householdId) {
        Pet pet = new Pet();
        pet.setName(name);
        pet.setType(type);
        // Set household if necessary
        return petRepository.save(pet);
    }

    @MutationMapping
    public Pet updatePet(@Argument Long id, @Argument String name, @Argument String type) {
        Pet pet = petRepository.findById(id).orElse(null);
        if (pet != null) {
            if (name != null) pet.setName(name);
            if (type != null) pet.setType(type);
            petRepository.save(pet);
        }
        return pet;
    }

    @MutationMapping
    public Boolean deletePet(@Argument Long id) {
        petRepository.deleteById(id);
        return true;
    }
}
