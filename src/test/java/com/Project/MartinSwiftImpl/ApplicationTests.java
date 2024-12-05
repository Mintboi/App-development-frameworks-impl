// PetRepositoryTest.java
package com.example.petshouseholdservice.repository;

import com.Project.MartinSwiftImpl.Repositories.PetRepository;
import com.example.petshouseholdservice.model.Pet;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.Project.MartinSwiftImpl.Objects.Pet;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ApplicationTests {

	@Autowired
	private PetRepository petRepository;

	@Test
	public void testCreateAndFindPet() {
		Pet pet = new Pet();
		pet.setName("Buddy");
		pet.setType("Dog");

		Pet savedPet = petRepository.save(pet);
		assertNotNull(savedPet.getId());

		Pet foundPet = petRepository.findById(savedPet.getId()).orElse(null);
		assertNotNull(foundPet);
		assertEquals("Buddy", foundPet.getName());
	}
}
