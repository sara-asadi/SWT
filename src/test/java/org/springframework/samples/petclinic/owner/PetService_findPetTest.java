package org.springframework.samples.petclinic.owner;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.samples.petclinic.utility.PetTimedCache;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class PetService_findPetTest {

	private int petId;
	private Pet pet;

	public static Pet foundPet1 = new Pet();
	public static Pet foundPet2 = new Pet();

	public PetService_findPetTest(int petId, Pet pet) {
		this.petId = petId;
		this.pet = pet;
	}

	@Before
	public void setUp() {
		foundPet1.setId(12);
		foundPet2.setId(34);
	}

	@Parameterized.Parameters
	public static Collection parameters() {
		return Arrays.asList(new Object[][] {
			{ 12, foundPet1},
			{ 34, foundPet2}
		});
	}

	@Test
	public void Pet_found_correctly() {
		OwnerRepository owners = mock(OwnerRepository.class);
		Logger logger = mock(Logger.class);
		PetTimedCache pets = mock(PetTimedCache.class);
		PetService petService = new PetService(pets, owners, logger);
		when(pets.get(petId)).thenReturn(pet);
		assertEquals(petService.findPet(petId).getId(), pet.getId());
	}
}
