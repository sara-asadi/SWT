package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

	private Owner owner = new Owner();
	private Pet cat, dog;

	@BeforeEach
	public void setUp() {
		cat = new Pet();
		dog = new Pet();
		cat.setName("Cat");
		dog.setName("Dog");
	}

	@Test
	public void Sorted_pets_are_returned_correctly() {
		owner.setPetsInternal(Set.of(dog, cat));
		assertEquals(List.of(cat, dog), owner.getPets());
	}

	@Test
	public void Owner_with_no_pet_returns_empty_list() {
		assertTrue(owner.getPets().isEmpty());
	}

	@Test
	public void New_pet_is_added_to_owner_correctly() {
		owner.addPet(cat);
		assertEquals(List.of(cat), owner.getPets());
		assertEquals(cat.getOwner(), owner);
	}

	@Test
	public void Pet_with_id_is_not_added_to_owner_correctly() {
		dog.setId(12);
		owner.addPet(dog);
		assertEquals(List.of(), owner.getPets());
		assertEquals(dog.getOwner(), owner);
	}

	@Test
	public void New_pet_not_found_if_we_ignore_new_pets() {
		owner.addPet(cat);
		assertNull(owner.getPet("cat", true));
	}

	@Test
	public void Pet_with_id_found_if_we_ignore_new_pets() {
		cat.setId(12);
		owner.setPetsInternal(Set.of(cat));
		assertEquals(cat, owner.getPet("cat", true));
	}

	@Test
	public void New_pet_found_generally() {
		owner.addPet(cat);
		assertEquals(cat, owner.getPet("cat"));
	}

	@Test
	public void New_pet_not_found_generally() {
		owner.addPet(cat);
		assertNull(owner.getPet("dog"));
	}

}
