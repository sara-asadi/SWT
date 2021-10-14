package org.springframework.samples.petclinic.owner;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PetService_findPetTest {
	//	public int petId;
//	public Pet pet = new Pet();
//	Pet cat = new Pet();
//
//	public PetServiceTest (int id, Pet expected) {
//		this.petId = id;
//		this.pet = expected;
//		cat.setId(12);
//	}
//
//	@Parameterized.Parameters
//	public static Collection<Object[]> parameters() {
//		return Arrays.asList (new Object [][] {{12, cat}, {2, null}});
//	}
//
//	@Test public void Pet_found_correctly() {
//		PetTimedCache pets = mock(PetTimedCache.class);
//		OwnerRepository owners = mock(OwnerRepository.class);
//		Logger log = mock(Logger.class);
//		PetService petService = new PetService(pets, owners, log);
//		when(pets.get(12)).thenReturn(cat);
//		assertTrue (pet == cat);
//	}
}
