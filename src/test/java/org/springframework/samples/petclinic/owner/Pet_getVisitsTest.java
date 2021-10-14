package org.springframework.samples.petclinic.owner;

import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;
import org.springframework.samples.petclinic.visit.Visit;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Theories.class)
public class Pet_getVisitsTest {

	@DataPoint
	public static LocalDate v1 = LocalDate.of(2021, 10, 11);
	@DataPoint
	public static LocalDate v2 = LocalDate.of(2000, 2, 11);
	@DataPoint
	public static LocalDate v3 = LocalDate.of(1999, 7, 24);

	@Theory
	public void Sorted_visits_are_return_correctly(LocalDate a, LocalDate b, LocalDate c) {
		Pet pet = new Pet();
		assumeTrue(a != b && b != c && a != c);
		pet.addVisit(new Visit().setDate(a));
		pet.addVisit(new Visit().setDate(b));
		pet.addVisit(new Visit().setDate(c));
		List<Visit> result = pet.getVisits();
		assertEquals(result.get(0).getDate(), v1);
		assertEquals(result.get(1).getDate(), v2);
		assertEquals(result.get(2).getDate(), v3);
	}

}
