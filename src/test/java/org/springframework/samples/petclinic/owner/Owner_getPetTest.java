package org.springframework.samples.petclinic.owner;


import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(Theories.class)
public class Owner_getPetTest {

	static Pet cat = new Pet();
	static Pet dog = new Pet();

	public Owner_getPetTest() {
		cat.setName("cat");
		dog.setName("dog");
		cat.setId(12);
	}

	@DataPoints
	public static String[] pet = {"rabbit", "cat", "dog"};
	@DataPoints
	public static Set[] pets = {
		new HashSet (),
		new HashSet (Arrays.asList (cat, dog))
	};

	@Theory
	public void Owner_with_no_pets_returns_null(String pet, Set<Pet> pets) {
		Owner owner = new Owner();
		assumeTrue(pets.equals(this.pets[0]));
		owner.setPetsInternal(pets);
		assertNull(owner.getPet(pet));
	}

	@Theory
	public void Pet_not_found_generally(String pet, Set<Pet> pets) {
		Owner owner = new Owner();
		assumeTrue(pet.equals("rabbit"));
		owner.setPetsInternal(pets);
		assertNull(owner.getPet(pet));
	}

	@Theory
	public void Pet_found_generally(String pet, Set<Pet> pets) {
		Owner owner = new Owner();
		assumeTrue(!pet.equals("rabbit"));
		assumeTrue(!pets.equals(this.pets[0]));
		owner.setPetsInternal(pets);
		assertEquals(owner.getPet(pet).getName(), pet);
	}

	@Theory
	public void New_pet_not_found_if_we_ignore_new_one(String pet, Set<Pet> pets) {
		Owner owner = new Owner();
		assumeTrue(pet.equals("dog"));
		owner.setPetsInternal(pets);
		assertNull(owner.getPet(pet, true));
	}

}




